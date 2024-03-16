package com.step.step_step.stats.presentation

data class StatsSummaryState(
    val isRefreshing: Boolean = false,
    val stepsTaken: Long = 0L,
    val calorieBurned: Double = 0.0,
    val distanceTravelled: Double = 0.0,
    val locsmanskayaMile: Double = 0.0,
)
