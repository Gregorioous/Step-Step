package com.step.step_step.settings.data.source

import com.step.step_step.settings.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsStore {

    fun getSettings(): Flow<Settings>
}