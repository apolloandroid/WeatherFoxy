package space.riri.weatherfoxy.presentation.currentweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import space.riri.weatherfoxy.data.repo.WeatherRepository
import space.riri.weatherfoxy.presentation.currentweather.mapper.TodayWeatherItemMapper
import space.riri.weatherfoxy.presentation.currentweather.mapper.WeekWeatherItemMapper
import space.riri.weatherfoxy.presentation.hourlyweather.HourlyWeatherModelUiState
import space.riri.weatherfoxy.presentation.hourlyweather.mapper.HourlyWeatherItemMapper
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val todayMapper: TodayWeatherItemMapper,
    private val weekMapper: WeekWeatherItemMapper
) : ViewModel(){

    private val mutableUiState = MutableLiveData<CurrentWeatherUiState>()
    val uiState : LiveData<CurrentWeatherUiState> = mutableUiState

    fun onViewCreated() {
        mutableUiState.value = CurrentWeatherUiState(isLoading = true)
        weatherRepository.getTodayWeather()
            .combine(weatherRepository.getWeekWeather()){todayModel, weekModels ->
                CurrentWeatherUiState(
                    todayModel = todayMapper.map(todayModel),
                    weekItems = weekMapper.map(weekModels)
                )
            }
            .onEach { state ->
                mutableUiState.postValue(state)
            }
            .flowOn(Dispatchers.IO)
            .catch {throwable ->
                throwable.printStackTrace()
            }
            .launchIn(viewModelScope)
    }
}