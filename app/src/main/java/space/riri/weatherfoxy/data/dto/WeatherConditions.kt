package space.riri.weatherfoxy.data.dto

import com.google.gson.annotations.SerializedName

enum class WeatherConditions {
    @SerializedName("SUNNY")
    SUNNY,
    @SerializedName("RAINY")
    RAINY,
    @SerializedName("SNOWFALL")
    SNOWFALL,
    @SerializedName("SNOWFALL_WITH_WIND")
    SNOWFALL_WITH_WIND,
    @SerializedName("CLOUDY")
    CLOUDY,
    @SerializedName("THUNDERSTORM")
    THUNDERSTORM
}