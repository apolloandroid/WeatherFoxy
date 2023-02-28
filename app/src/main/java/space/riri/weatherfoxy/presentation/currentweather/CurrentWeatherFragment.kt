package space.riri.weatherfoxy.presentation.currentweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import space.riri.weatherfoxy.R
import space.riri.weatherfoxy.presentation.currentweather.adapter.CurrentWeatherAdapter
import space.riri.weatherfoxy.databinding.CurrentWeatherFragmentBinding
import space.riri.weatherfoxy.utils.setImageDrawable

@AndroidEntryPoint
class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var binding: CurrentWeatherFragmentBinding
    private val viewModel : CurrentWeatherViewModel by viewModels()

    private val adapter by lazy {
        CurrentWeatherAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CurrentWeatherFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupView()
        viewModel.onViewCreated()
        viewModel.uiState.observe(viewLifecycleOwner){state ->
            binding.titleTemper.text = state?.todayModel?.temperature.toString()
            binding.calendar.text = state?.todayModel?.title
            binding.snowfall.setText(state?.todayModel?.subTitle ?: R.string.thunderstorm)
            binding.imageViewWinter.setImageDrawable(state?.todayModel?.drawableRes ?: R.drawable.ic_foxy_winter)
            adapter.addItems(state.weekItems)
        }
    }


    private fun CurrentWeatherFragmentBinding.setupView() {
        weatherList.adapter = adapter
    }
}