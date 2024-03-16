package com.step.step_step.stats.domain.usecase

import com.step.step_step.core.domain.repository.DayRepository

class StatsDetailsUseCases(
    dayRepository: DayRepository
) {

    val getFirstDate: GetFirstDate = GetFirstDateImpl(dayRepository)
}