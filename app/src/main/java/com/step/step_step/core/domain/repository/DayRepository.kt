package com.step.step_step.core.domain.repository

import com.step.step_step.core.domain.model.Day
import com.step.step_step.core.domain.model.DaySettings
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface DayRepository {
    fun getFirstDay(): Flow<Day?>

    fun getDay(date: LocalDate): Flow<Day?>

    suspend fun getAllDays(): List<Day>

    fun getDays(range: ClosedRange<LocalDate>): Flow<List<Day>>

    suspend fun upsertDay(day: Day)

    suspend fun updateDaySettings(daySettings: DaySettings)
}