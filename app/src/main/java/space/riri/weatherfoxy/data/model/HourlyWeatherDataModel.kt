package space.riri.weatherfoxy.data.model


import space.riri.weatherfoxy.data.dto.WeatherConditions

data class HourlyWeatherDataModel (
    val date: String,
    val time: String,
    val temperature: Int,
    val precipitation: Int,
    val humidity: Int,
    val uvIndex: Int,
    val pressure: Int,
    val visibility: Int,
    val weatherConditions: WeatherConditions
)