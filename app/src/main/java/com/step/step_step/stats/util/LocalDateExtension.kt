package com.step.step_step.stats.util

import com.google.android.material.R
import com.step.step_step.core.domain.model.Day
import com.step.step_step.stats.presentation.adapter.ChartValue
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

operator fun ClosedRange<LocalDate>.iterator() = object : Iterator<LocalDate> {

    private var current = start.minusDays(1)

    override fun hasNext(): Boolean {
        return current.isBefore(endInclusive)
    }

    override fun next(): LocalDate {
        if (current.isBefore(endInclusive)) {
            current = current.plusDays(1)
        }
        return current
    }
}

fun List<Day>.toChartValues(
    max: Int,
    locale: Locale,
    activeDay: LocalDate
): List<ChartValue<LocalDate>> = map {
    val value = it.steps / max.toDouble()
    val weekdayName = it.date.dayOfWeek.getDisplayName(TextStyle.SHORT, locale)
    val isSelected = it.date.isEqual(activeDay)
    val barColor =
        if (isSelected) R.attr.colorPrimary
        else R.attr.colorPrimaryContainer
    val textColor =
        if (isSelected) R.attr.colorPrimary
        else R.attr.colorAccent
    ChartValue(
        it.date,
        value = value,
        label = weekdayName,
        barColor = barColor,
        textColor = textColor
    )
}