package com.step.step_step.stats.presentation.adapter

fun interface OnValueSelected<T> {
    fun onSelect(value: ChartValue<T>)
}