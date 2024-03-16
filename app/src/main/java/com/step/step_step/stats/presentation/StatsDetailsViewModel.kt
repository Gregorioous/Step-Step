package com.step.step_step.stats.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.step.step_step.StepApplication
import com.step.step_step.core.data.repository.DayRepositoryImpl
import com.step.step_step.core.domain.usecase.DayUseCases
import com.step.step_step.settings.data.repository.SettingsRepositoryImpl
import com.step.step_step.stats.domain.usecase.StatsDetailsUseCases
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import kotlin.math.roundToInt

class StatsDetailsViewModel(
    private val dayUseCases: DayUseCases,
    statsDetailsUseCases: StatsDetailsUseCases,
    currentDateFlow: StateFlow<LocalDate>
) : ViewModel() {

    private val _day = MutableStateFlow(
        StatsDetailsState(
            date = LocalDate.MIN,
            stepsTaken = 0,
            calorieBurned = 0,
            distanceTravelled = 0.0,
            locsmanskayaMile = 0.0,
            chartDateRange = currentDateFlow.value..currentDateFlow.value
        )
    )
    val day: StateFlow<StatsDetailsState> = _day.asStateFlow()

    init {
        selectDay(currentDateFlow.value)

        viewModelScope.launch {
            val firstDateFlow = statsDetailsUseCases.getFirstDate()
            firstDateFlow
                .combine(currentDateFlow) { firstDate, currentDate ->
                    firstDate..currentDate
                }.collect { dateRange ->
                    _day.value = day.value.copy(chartDateRange = dateRange)
                }
        }
    }

    private var selectDateJob: Job? = null

    fun selectDay(date: LocalDate) {
        selectDateJob?.cancel()
        selectDateJob = dayUseCases.getDay(date).onEach {
            _day.value = day.value.copy(
                date = it.date,
                stepsTaken = it.steps,
                calorieBurned = it.calorieBurned.roundToInt(),
                distanceTravelled = it.distanceTravelled,
                locsmanskayaMile = it.locsmanskayaMile
            )
        }.launchIn(viewModelScope)
    }

    companion object Factory : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            val application =
                checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as StepApplication

            val dayDatabase = application.stepDataBase
            val dayRepository = DayRepositoryImpl(dayDatabase.dayDao)
            val settingsStore = application.settingsStore
            val settingsRepository = SettingsRepositoryImpl(settingsStore)
            val dayUseCases = DayUseCases(dayRepository, settingsRepository)
            val statsDetailsUseCases = StatsDetailsUseCases(dayRepository)

            return StatsDetailsViewModel(
                dayUseCases,
                statsDetailsUseCases,
                application.currentDate
            ) as T
        }
    }
}