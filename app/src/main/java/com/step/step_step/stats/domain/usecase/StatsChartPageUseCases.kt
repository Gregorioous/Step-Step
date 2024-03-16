package com.step.step_step.stats.domain.usecase

import com.step.step_step.core.domain.repository.DayRepository

class StatsChartPageUseCases(
    dayRepository: DayRepository
) {

    val getWeek: GetWeek = GetWeekImpl(dayRepository)
}