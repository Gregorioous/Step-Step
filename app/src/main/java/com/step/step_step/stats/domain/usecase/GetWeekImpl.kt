package com.step.step_step.stats.domain.usecase

import com.step.step_step.core.domain.model.Day
import com.step.step_step.core.domain.repository.DayRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetWeekImpl(
    private val dayRepository: DayRepository
) : GetWeek {

    override fun invoke(startingAt: LocalDate): Flow<List<Day>> {
        val endingAt = startingAt.plusDays(6)
        return dayRepository.getDays(startingAt..endingAt)
    }
}