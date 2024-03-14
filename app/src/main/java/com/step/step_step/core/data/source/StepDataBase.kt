package com.step.step_step.core.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.step.step_step.core.data.source.utill.Converters
import com.step.step_step.core.domain.model.Day

@Database(entities = [Day::class], version = 1)
@TypeConverters(Converters::class)
abstract class StepDataBase : RoomDatabase() {

    abstract val dayDao: DayDao

    companion object {
        const val DATABASE_NAME = "forest_database"
    }
}