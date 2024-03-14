package com.step.step_step.settings.domain.usecase

import com.step.step_step.settings.domain.model.Settings
import com.step.step_step.settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

class GetSettingsImpl(
    private val repository: SettingsRepository
) : GetSettings {

    override fun invoke(): Flow<Settings> {
        return repository.getSettings()
    }
}