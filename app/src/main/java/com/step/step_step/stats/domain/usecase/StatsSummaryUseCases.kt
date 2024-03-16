package com.step.step_step.stats.domain.usecase

import com.step.step_step.core.domain.repository.DayRepository

class StatsSummaryUseCases(
    dayRepository: DayRepository
) {

    val getSummary: GetSummary = GetSummaryImpl(dayRepository)
}