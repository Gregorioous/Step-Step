package com.step.step_step.stats.presentation.adapter

import androidx.annotation.AttrRes

data class ChartValue<T>(

    val id: T,

    val value: Double,

    val label: String,

    @AttrRes
    val barColor: Int,

    @AttrRes
    val textColor: Int,
)