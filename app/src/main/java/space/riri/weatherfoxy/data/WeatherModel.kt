package space.riri.weatherfoxy.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WeatherModel(
    @StringRes
    val day: Int,
    val temp: Int,
    @DrawableRes
    val icon: Int
)
