package space.riri.weatherfoxy.presentation.currentweather.mapper

import androidx.annotation.DrawableRes
import space.riri.weatherfoxy.R
import space.riri.weatherfoxy.data.dto.WeatherConditions
import space.riri.weatherfoxy.data.model.HourlyWeatherDataModel
import space.riri.weatherfoxy.data.model.WeekWeatherDataModel
import space.riri.weatherfoxy.presentation.currentweather.model.ItemWeatherModel
import space.riri.weatherfoxy.presentation.hourlyweather.model.ItemHourlyModel
import javax.inject.Inject

class WeekWeatherItemMapper @Inject constructor() {

    fun map(dataModels: List<WeekWeatherDataModel>) : List<ItemWeatherModel> {
        return dataModels.map(::mapToItem)
    }

    private fun mapToItem(dataModel: WeekWeatherDataModel) : ItemWeatherModel {
        return ItemWeatherModel(
            day = dataModel.day,
            temp = dataModel.temperature.toString(),
            iconRes = getIconRes(dataModel.weatherConditions)
        )
    }

    @DrawableRes
    private fun getIconRes(conditions: WeatherConditions) : Int? {
        return when(conditions){
            WeatherConditions.SUNNY -> R.drawable.ic_cloud_sun
            WeatherConditions.RAINY -> null
            WeatherConditions.SNOWFALL -> R.drawable.ic_cloud_snowfall
            WeatherConditions.SNOWFALL_WITH_WIND -> R.drawable.ic_cloud_snowfall_wind
            WeatherConditions.CLOUDY -> null
            WeatherConditions.THUNDERSTORM -> null
        }
    }
}