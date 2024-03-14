package com.step.step_step.core.data.source.utill

import androidx.room.TypeConverter
import java.time.LocalDate

@Suppress("unused")
class Converters {
    @TypeConverter
    fun localDateToTimestamp(date: LocalDate): Long {
        return date.toEpochDay()
    }

    @TypeConverter
    fun timestampToLocalDate(timestamp: Long): LocalDate {
        return LocalDate.ofEpochDay(timestamp)
    }
}