package com.step.step_step.settings.data.source

import android.content.SharedPreferences
import com.step.step_step.settings.domain.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsStoreImpl(
    private val sharedPreferences: SharedPreferences
) : SettingsStore, SharedPreferences.OnSharedPreferenceChangeListener {

    private val settings: MutableStateFlow<Settings>

    init {
        val parsedSettings = parseSettings(sharedPreferences)
        settings = MutableStateFlow(parsedSettings)
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun getSettings(): Flow<Settings> {
        return settings.asStateFlow()
    }

    private fun parseSettings(sharedPreferences: SharedPreferences): Settings =
        sharedPreferences.run {
            Settings(
                dailyGoal = getNumericString("daily_goal", 0),
                stepLength = getNumericString("step_length", 0),
                height = getNumericString("height", 0),
                weight = getNumericString("weight", 0),
                pace = getNumericString("pace", 0.0)
            )
        }

    private fun SharedPreferences.getNumericString(key: String, defaultValue: Int): Int =
        getString(key, "")?.toIntOrNull() ?: defaultValue

    private fun SharedPreferences.getNumericString(key: String, defaultValue: Double): Double =
        getString(key, "")?.toDoubleOrNull() ?: defaultValue

    override fun onSharedPreferenceChanged(
        updatedSharedPreferences: SharedPreferences?,
        key: String?
    ) {
        settings.value = parseSettings(sharedPreferences)
    }
}