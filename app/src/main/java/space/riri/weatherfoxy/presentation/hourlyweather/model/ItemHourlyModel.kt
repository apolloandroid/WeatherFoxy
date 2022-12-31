package space.riri.weatherfoxy.presentation.hourlyweather.model


import androidx.annotation.DrawableRes

data class ItemHourlyModel(
    val id: String = "",
    val date: String,
    val time: String,
    val temperature: Int,
    val precipitation: Int,
    val humidity: Int,
    val uvIndex: Int,
    val pressure: Int,
    val visibility: Int,
    @DrawableRes
    val iconHourly: Int?
)