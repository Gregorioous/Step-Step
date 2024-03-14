package com.step.step_step.core.domain.usecase

import java.time.LocalDate

interface IncrementStepCount {
    suspend operator fun invoke(date: LocalDate, by: Int)
}