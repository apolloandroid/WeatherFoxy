package space.riri.weatherfoxy.data.model

import space.riri.weatherfoxy.data.dto.WeatherConditions

data class WeekWeatherDataModel(
    val day: String,
    val temperature:Int,
    val weatherConditions: WeatherConditions
)
