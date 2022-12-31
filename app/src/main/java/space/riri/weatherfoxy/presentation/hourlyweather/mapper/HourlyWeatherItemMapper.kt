package space.riri.weatherfoxy.presentation.hourlyweather.mapper

import androidx.annotation.DrawableRes
import space.riri.weatherfoxy.R
import space.riri.weatherfoxy.data.dto.WeatherConditions
import space.riri.weatherfoxy.data.model.HourlyWeatherDataModel
import space.riri.weatherfoxy.presentation.hourlyweather.model.ItemHourlyModel
import javax.inject.Inject

class HourlyWeatherItemMapper @Inject constructor() {

    fun map(dataModels: List<HourlyWeatherDataModel>) : List<ItemHourlyModel> {
        return dataModels.map(::mapToItem)
    }

    private fun mapToItem(dataModel: HourlyWeatherDataModel) : ItemHourlyModel {
        return ItemHourlyModel(
            id = "",
            date = dataModel.date,
            time = dataModel.time,
            temperature = dataModel.temperature,
            pressure = dataModel.pressure,
            humidity = dataModel.humidity,
            uvIndex = dataModel.uvIndex,
            precipitation = dataModel.precipitation,
            visibility =  dataModel.visibility,
            iconHourly = getIconRes(dataModel.weatherConditions)
        )
    }

    @DrawableRes
    private fun getIconRes(conditions: WeatherConditions) : Int? {
        return when(conditions){
            WeatherConditions.SUNNY -> R.drawable.ic_hourly_sun
            WeatherConditions.RAINY -> R.drawable.ic_cloud_rain
            else -> null
        }
    }
}