package space.riri.weatherfoxy.data.model

import space.riri.weatherfoxy.data.dto.WeatherConditions

data class TodayWeatherDataModel(
    val date: String,
    val day: Int,
    val month: String,
    val temperature:Int,
    val weatherConditions: WeatherConditions
)
