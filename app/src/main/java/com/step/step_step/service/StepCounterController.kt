package com.step.step_step.service

import com.step.step_step.core.domain.usecase.DayUseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate

class StepCounterController(
    private val dayUseCases: DayUseCases,
    private val coroutineScope: CoroutineScope,
    currentDateFlow: StateFlow<LocalDate>
) {

    private val _state = MutableStateFlow(StepCounterState(LocalDate.now(), 0, 0, 0.0, 0))
    val stats: StateFlow<StepCounterState> = _state.asStateFlow()
}