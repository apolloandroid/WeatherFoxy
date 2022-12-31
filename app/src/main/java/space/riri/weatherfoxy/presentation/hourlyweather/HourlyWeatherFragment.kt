package space.riri.weatherfoxy.presentation.hourlyweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import space.riri.weatherfoxy.R
import space.riri.weatherfoxy.databinding.HourlyWeatherBinding
import space.riri.weatherfoxy.presentation.hourlyweather.adapter.HourlyWeatherAdapter
import space.riri.weatherfoxy.presentation.hourlyweather.model.ItemHourlyModel

@AndroidEntryPoint
class HourlyWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = HourlyWeatherFragment()
    }

    private lateinit var binding: HourlyWeatherBinding
    private val adapter by lazy {
        HourlyWeatherAdapter()
    }

    private val viewModel : HourlyWeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HourlyWeatherBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupView()
        viewModel.onViewCreated()
        viewModel.uiState.observe(viewLifecycleOwner){state ->
            binding.progressBar.isVisible = state.isLoading
            binding.hourlyItemList.isGone = state.isLoading
            adapter.addItems(state.items)
        }
    }

    private fun HourlyWeatherBinding.setupView() {
        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.background_divider) ?: return
        decoration.setDrawable(drawable)
        hourlyItemList.addItemDecoration(decoration)
        hourlyItemList.adapter = adapter
    }
}