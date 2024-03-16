package com.step.step_step.stats.domain.usecase

import com.step.step_step.core.domain.model.Day
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface GetWeek {

    operator fun invoke(startingAt: LocalDate): Flow<List<Day>>
}