package com.step.step_step.stats.domain.usecase

import com.step.step_step.core.domain.model.StatsSummary

interface GetSummary {
    suspend operator fun invoke(): StatsSummary
}