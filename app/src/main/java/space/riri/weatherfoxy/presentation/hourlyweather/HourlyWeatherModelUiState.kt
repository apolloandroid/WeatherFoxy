package space.riri.weatherfoxy.presentation.hourlyweather

import space.riri.weatherfoxy.presentation.hourlyweather.model.ItemHourlyModel

data class HourlyWeatherModelUiState(
    val isLoading : Boolean = false,
    val isError: Boolean = false,
    val items: List<ItemHourlyModel> = emptyList()
)
