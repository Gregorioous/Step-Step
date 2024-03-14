package com.step.step_step.progress

import java.time.LocalDate

data class ProgressState(
    val date: LocalDate,
    val stepsTaken: Int,
    val dailyGoal: Int,
    val calorieBurned: Int,
    val distanceTravelled: Double,
    val carbonDioxideSaved: Double,
)