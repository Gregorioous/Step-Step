package com.step.step_step.stats.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

internal class DiffCallback<T> : DiffUtil.ItemCallback<ChartValue<T>>() {

    override fun areItemsTheSame(oldItem: ChartValue<T>, newItem: ChartValue<T>): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChartValue<T>, newItem: ChartValue<T>): Boolean {
        return oldItem == newItem
    }
}