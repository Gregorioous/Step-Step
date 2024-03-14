package com.step.step_step.settings.data.repository

import com.step.step_step.settings.data.source.SettingsStore
import com.step.step_step.settings.domain.model.Settings
import com.step.step_step.settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl(
    private val settingsStore: SettingsStore
) : SettingsRepository {

    override fun getSettings(): Flow<Settings> {
        return settingsStore.getSettings()
    }
}