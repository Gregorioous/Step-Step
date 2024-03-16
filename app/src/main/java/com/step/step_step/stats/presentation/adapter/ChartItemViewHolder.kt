package com.step.step_step.stats.presentation.adapter

import android.content.res.ColorStateList
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.step.step_step.databinding.ItemChartBarBinding
import com.step.step_step.stats.util.getThemeColor

class ChartItemViewHolder<T>(
    private val binding: ItemChartBarBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(chartValue: ChartValue<T>, listener: OnValueSelected<T>) {
        binding.root.setOnClickListener { listener.onSelect(chartValue) }
        binding.textSupporting.apply {
            text = chartValue.label
            val color = context.getThemeColor(chartValue.textColor)
            setTextColor(color)
        }
        binding.barFilled.apply {
            val color = context.getThemeColor(chartValue.barColor)
            backgroundTintList = ColorStateList.valueOf(color)
            val params = layoutParams as ConstraintLayout.LayoutParams
            params.matchConstraintPercentHeight = chartValue.value.toFloat()
            requestLayout()
        }
    }
}