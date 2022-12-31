package space.riri.weatherfoxy.data.mapper

import space.riri.weatherfoxy.data.api.response.HourlyWeatherResponse
import space.riri.weatherfoxy.data.model.HourlyWeatherDataModel
import javax.inject.Inject

class HourlyWeatherDataMapper @Inject constructor() {

    fun map(responses: List<HourlyWeatherResponse>): List<HourlyWeatherDataModel> {
        return responses.map(::mapToModel)
    }

    private fun mapToModel(response: HourlyWeatherResponse): HourlyWeatherDataModel {
        return HourlyWeatherDataModel(
            date = response.date,
            time = response.time,
            temperature = response.temperature,
            precipitation = response.precipitation,
            humidity = response.humidity,
            uvIndex = response.uvIndex,
            pressure = response.pressure,
            visibility = response.visibility,
            weatherConditions = response.weatherConditions
        )
    }
}