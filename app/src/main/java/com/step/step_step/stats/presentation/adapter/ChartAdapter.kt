package com.step.step_step.stats.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.step.step_step.databinding.ItemChartBarBinding

class ChartAdapter<T>(
    private val listener: OnValueSelected<T>
) : ListAdapter<ChartValue<T>, ChartItemViewHolder<T>>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartItemViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemChartBarBinding.inflate(layoutInflater, parent, false)
        return ChartItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChartItemViewHolder<T>, position: Int) {
        val value = getItem(position)
        holder.bind(value, listener)
    }
}