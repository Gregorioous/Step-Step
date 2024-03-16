package com.step.step_step.core.domain.model

data class StatsSummary(
    val stepsTaken: Long = 0L,
    val calorieBurned: Double = 0.0,
    val distanceTravelled: Double = 0.0,
    val locsmanskayaMile: Double = 0.0,
) {
    companion object
}

fun StatsSummary.Companion.of(days: List<Day>): StatsSummary {
    val stepsTaken = days.sumOf { it.steps.toLong() }
    val calorieBurned = days.sumOf { it.calorieBurned }
    val distanceTravelled = days.sumOf { it.distanceTravelled }
    val locsmanskayaMile = days.sumOf { it.locsmanskayaMile }
    return StatsSummary(
        stepsTaken = stepsTaken,
        calorieBurned = calorieBurned,
        distanceTravelled = distanceTravelled,
        locsmanskayaMile = locsmanskayaMile
    )
}