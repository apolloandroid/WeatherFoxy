package space.riri.weatherfoxy.data.api.response

import com.google.gson.annotations.SerializedName
import space.riri.weatherfoxy.data.dto.WeatherConditions

data class WeekWeatherResponse(
    @SerializedName("week_day")
    val weekday: String,
    @SerializedName("temperature")
    val temperature: Int,
    @SerializedName("weather_conditions")
    val weatherConditions: WeatherConditions
)
