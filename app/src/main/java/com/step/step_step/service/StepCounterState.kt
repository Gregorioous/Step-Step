package com.step.step_step.service

import java.time.LocalDate

data class StepCounterState(
    val date: LocalDate,
    val steps: Int,
    val goal: Int,
    val distanceTravelled: Double,
    val calorieBurned: Int
)
