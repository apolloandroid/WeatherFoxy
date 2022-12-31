package space.riri.weatherfoxy.data.api.response

import com.google.gson.annotations.SerializedName
import space.riri.weatherfoxy.data.dto.WeatherConditions
import space.riri.weatherfoxy.data.model.WeekWeatherDataModel

data class TodayWeatherResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("day")
    val day: Int,
    @SerializedName("month")
    val month: String,
    @SerializedName("temperature")
    val temperature: Int,
    @SerializedName("weather_conditions")
    val weatherConditions: WeatherConditions
)