package com.step.step_step.settings.domain.usecase

import com.step.step_step.core.domain.repository.DayRepository
import com.step.step_step.settings.domain.repository.SettingsRepository

class SettingsUseCases(
    settingsRepository: SettingsRepository,
    dayRepository: DayRepository,
) {

    val getSettings: GetSettings = GetSettingsImpl(settingsRepository)
    val updateDaySettings: UpdateDaySettings = UpdateDaySettingsImpl(dayRepository)
}