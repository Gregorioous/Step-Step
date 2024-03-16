package com.step.step_step.stats.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.step.step_step.R
import com.step.step_step.databinding.FragmentStatsDetailsBinding
import kotlinx.coroutines.launch

class StatsDetailsFragment : Fragment() {

    private val viewModel: StatsDetailsViewModel by activityViewModels { StatsDetailsViewModel }

    private lateinit var binding: FragmentStatsDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.day.collect { updateUserInterface(it) }
            }
        }
    }


    private fun updateUserInterface(state: StatsDetailsState) = state.apply {
        val stepsText = resources.getQuantityString(
            R.plurals.step_count_format, stepsTaken, stepsTaken
        )
        val calorieText = getString(
            R.string.calorie_burned_format, calorieBurned
        )
        val distanceText = getString(
            R.string.distance_travelled_format, distanceTravelled
        )
        val mileText = getString(R.string.mylia_saved_format, locsmanskayaMile.toString())

        binding.apply {
            textStepCount.text = stepsText
            textCalorieBurned.text = calorieText
            textDistanceTravelled.text = distanceText
            textMyliaProidenoSaved.text = mileText
        }
    }
}
