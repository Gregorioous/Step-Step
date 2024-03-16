package com.step.step_step.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.step.step_step.StepApplication
import com.step.step_step.core.data.repository.DayRepositoryImpl
import com.step.step_step.core.domain.model.DaySettings
import com.step.step_step.settings.data.repository.SettingsRepositoryImpl
import com.step.step_step.settings.domain.usecase.SettingsUseCases
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate

class SettingsViewModel(
    private val settingsUseCases: SettingsUseCases
) : ViewModel() {

    private var observeSettingsChangesJob: Job? = null

    fun observeSettingsChanges() {
        observeSettingsChangesJob?.cancel()
        observeSettingsChangesJob = settingsUseCases.getSettings().onEach {
            settingsUseCases.updateDaySettings(
                DaySettings(
                    date = LocalDate.now(),
                    goal = it.dailyGoal,
                    height = it.height,
                    weight = it.weight,
                    stepLength = it.stepLength,
                    pace = it.pace
                )
            )
        }.launchIn(viewModelScope)
    }

    companion object Factory : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            val application =
                checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as StepApplication

            val settingsStore = application.settingsStore
            val settingsRepository = SettingsRepositoryImpl(settingsStore)
            val dayDatabase = application.stepDataBase
            val dayRepository = DayRepositoryImpl(dayDatabase.dayDao)

            val settingsUseCases = SettingsUseCases(settingsRepository, dayRepository)

            return SettingsViewModel(settingsUseCases) as T
        }
    }
}