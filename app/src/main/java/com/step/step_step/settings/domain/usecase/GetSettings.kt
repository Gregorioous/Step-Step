package com.step.step_step.settings.domain.usecase

import com.step.step_step.settings.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface GetSettings {

    operator fun invoke(): Flow<Settings>
}
