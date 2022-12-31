package space.riri.weatherfoxy.presentation.currentweather

import space.riri.weatherfoxy.presentation.currentweather.model.ItemWeatherModel
import space.riri.weatherfoxy.presentation.currentweather.model.TodayWeatherModel

data class CurrentWeatherUiState(
    val isLoading: Boolean = false,
    val todayModel: TodayWeatherModel? = null,
    val weekItems: List<ItemWeatherModel> = emptyList()
)
