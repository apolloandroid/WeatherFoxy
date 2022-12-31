package space.riri.weatherfoxy.data.api.response

import com.google.gson.annotations.SerializedName
import space.riri.weatherfoxy.data.dto.WeatherConditions


data class HourlyWeatherResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("temperature")
    val temperature: Int,
    @SerializedName("precipitation")
    val precipitation: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("uv_index")
    val uvIndex: Int,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather_conditions")
    val weatherConditions: WeatherConditions
)