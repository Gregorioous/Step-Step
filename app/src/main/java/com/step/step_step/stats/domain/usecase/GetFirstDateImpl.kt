package com.step.step_step.stats.domain.usecase

import com.step.step_step.core.domain.repository.DayRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class GetFirstDateImpl(
    private val dayRepository: DayRepository
) : GetFirstDate {

    override fun invoke(): Flow<LocalDate> {
        return dayRepository.getFirstDay().map { it?.date ?: LocalDate.now() }
    }
}