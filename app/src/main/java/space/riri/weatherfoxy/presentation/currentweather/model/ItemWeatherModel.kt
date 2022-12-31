package space.riri.weatherfoxy.presentation.currentweather.model

import androidx.annotation.DrawableRes

data class ItemWeatherModel(
    val day: String,
    val temp: String,
    @DrawableRes
    val iconRes: Int?
)
