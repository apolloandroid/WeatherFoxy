package space.riri.weatherfoxy.presentation.hourlyweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import space.riri.weatherfoxy.data.repo.WeatherRepository
import space.riri.weatherfoxy.presentation.hourlyweather.mapper.HourlyWeatherItemMapper
import javax.inject.Inject

@HiltViewModel
class HourlyWeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val itemMapper: HourlyWeatherItemMapper
) : ViewModel(){

    private val mutableUiState = MutableLiveData<HourlyWeatherModelUiState>()
    val uiState : LiveData<HourlyWeatherModelUiState> = mutableUiState

    fun onViewCreated() {
        mutableUiState.value = HourlyWeatherModelUiState(isLoading = true)
        weatherRepository.getHourlyWeather()
            .flowOn(Dispatchers.IO)
            .onEach {models ->
                val state = HourlyWeatherModelUiState(items = itemMapper.map(models))
                mutableUiState.value = state
            }
            .catch {throwable ->
                throwable.printStackTrace()
            }
            .launchIn(viewModelScope)
    }
}