package com.step.step_step.stats.presentation

import com.step.step_step.core.domain.model.Day
import java.time.LocalDate

data class StatsChartState(
    val week: List<Day>,
    val dateRange: ClosedRange<LocalDate>
) {
    companion object
}

fun StatsChartState.Companion.of(currentDate: LocalDate) = StatsChartState(
    week = emptyList(),
    dateRange = currentDate..currentDate
)