package com.step.step_step.settings.domain.repository

import com.step.step_step.settings.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getSettings(): Flow<Settings>
}