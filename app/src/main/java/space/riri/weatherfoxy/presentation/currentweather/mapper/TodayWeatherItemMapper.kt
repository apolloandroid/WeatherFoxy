package space.riri.weatherfoxy.presentation.currentweather.mapper

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import space.riri.weatherfoxy.R
import space.riri.weatherfoxy.data.dto.WeatherConditions
import space.riri.weatherfoxy.data.model.HourlyWeatherDataModel
import space.riri.weatherfoxy.data.model.TodayWeatherDataModel
import space.riri.weatherfoxy.presentation.currentweather.model.TodayWeatherModel
import space.riri.weatherfoxy.presentation.hourlyweather.model.ItemHourlyModel
import javax.inject.Inject

class TodayWeatherItemMapper @Inject constructor() {

    fun map(dataModel: TodayWeatherDataModel) : TodayWeatherModel {
        return TodayWeatherModel(
            temperature = dataModel.temperature,
            title = getTitle(dataModel),
            subTitle = getSubTitle(dataModel.weatherConditions),
            drawableRes = getIconRes(dataModel.weatherConditions)
        )
    }

    private fun getTitle(dataModel: TodayWeatherDataModel): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(dataModel.date)
            .append(", ")
            .append(dataModel.day)
            .append(" ${dataModel.month}")
        return stringBuilder.toString()
    }


    @StringRes
    private fun getSubTitle(conditions: WeatherConditions) : Int {
        return when(conditions){
            WeatherConditions.SUNNY -> R.string.summer_sun
            WeatherConditions.RAINY -> R.string.autumn_rain
            WeatherConditions.SNOWFALL -> R.string.snowfall
            WeatherConditions.SNOWFALL_WITH_WIND -> R.string.snowfall
            WeatherConditions.CLOUDY -> R.string.partly_cloudy
            WeatherConditions.THUNDERSTORM -> R.string.thunderstorm
        }
    }

    @DrawableRes
    private fun getIconRes(conditions: WeatherConditions) : Int {
        return when(conditions){
            WeatherConditions.SUNNY -> R.drawable.ic_foxy_summer
            WeatherConditions.RAINY -> R.drawable.ic_foxy_rain
            WeatherConditions.SNOWFALL -> R.drawable.ic_foxy_winter
            WeatherConditions.SNOWFALL_WITH_WIND -> R.drawable.ic_foxy_winter
            WeatherConditions.CLOUDY -> R.drawable.ic_foxy_winter
            WeatherConditions.THUNDERSTORM -> R.drawable.ic_foxy_winter
        }
    }
}