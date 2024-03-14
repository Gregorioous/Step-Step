package com.step.step_step.core.domain.usecase

import com.step.step_step.core.domain.model.Day
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface GetDay {
    operator fun invoke(date: LocalDate): Flow<Day>
}