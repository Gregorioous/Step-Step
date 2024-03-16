package com.step.step_step.stats.presentation

import java.time.LocalDate

data class StatsDetailsState(
    val date: LocalDate,
    val stepsTaken: Int,
    val calorieBurned: Int,
    val distanceTravelled: Double,
    val locsmanskayaMile: Double,
    val chartDateRange: ClosedRange<LocalDate>
)