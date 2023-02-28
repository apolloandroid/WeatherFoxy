package space.riri.weatherfoxy.presentation.currentweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import space.riri.weatherfoxy.data.repo.WeatherRepository
import space.riri.weatherfoxy.presentation.currentweather.mapper.TodayWeatherItemMapper
import space.riri.weatherfoxy.presentation.currentweather.mapper.WeekWeatherItemMapper
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val todayMapper: TodayWeatherItemMapper,
    private val weekMapper: WeekWeatherItemMapper
) : ViewModel() {

    private val mutableUiState = MutableLiveData<CurrentWeatherUiState>()
    val uiState: LiveData<CurrentWeatherUiState> = mutableUiState

    fun onViewCreated() {
        mutableUiState.value = CurrentWeatherUiState(isLoading = true)
        viewModelScope.launch {
            try {
                val models = async {
                    weatherRepository.getTodayWeather()
                }
                val weekModels = async { weatherRepository.getWeekWeather() }
                val state = CurrentWeatherUiState(
                    todayModel = todayMapper.map(models.await()),
                    weekItems = weekMapper.map(weekModels.await())

                )
                mutableUiState.postValue(state)


            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }

    }
}