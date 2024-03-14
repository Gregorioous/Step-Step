package com.step.step_step.settings.domain.usecase

import com.step.step_step.core.domain.model.DaySettings
import com.step.step_step.core.domain.repository.DayRepository

class UpdateDaySettingsImpl(
    private val dayRepository: DayRepository
) : UpdateDaySettings {

    override suspend fun invoke(daySettings: DaySettings) {
        dayRepository.updateDaySettings(daySettings)
    }
}