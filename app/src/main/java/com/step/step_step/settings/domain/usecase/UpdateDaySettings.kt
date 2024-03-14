package com.step.step_step.settings.domain.usecase

import com.step.step_step.core.domain.model.DaySettings

interface UpdateDaySettings {

    suspend operator fun invoke(daySettings: DaySettings)
}
