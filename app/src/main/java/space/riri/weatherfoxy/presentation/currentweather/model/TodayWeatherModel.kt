package space.riri.weatherfoxy.presentation.currentweather.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TodayWeatherModel(
    val temperature: Int,
    val title: String,
    @StringRes
    val subTitle: Int,
    @DrawableRes
    val drawableRes: Int
)
