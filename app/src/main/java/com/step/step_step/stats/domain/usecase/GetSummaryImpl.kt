package com.step.step_step.stats.domain.usecase

import com.step.step_step.core.domain.model.StatsSummary
import com.step.step_step.core.domain.model.of
import com.step.step_step.core.domain.repository.DayRepository

class GetSummaryImpl(
    private val dayRepository: DayRepository
) : GetSummary {

    override suspend operator fun invoke(): StatsSummary {
        val allDays = dayRepository.getAllDays()
        return StatsSummary.of(allDays)
    }
}