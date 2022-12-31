package space.riri.weatherfoxy.data.mapper

import space.riri.weatherfoxy.data.api.response.WeekWeatherResponse
import space.riri.weatherfoxy.data.dto.WeatherConditions
import space.riri.weatherfoxy.data.model.TodayWeatherDataModel
import space.riri.weatherfoxy.data.model.WeekWeatherDataModel
import javax.inject.Inject

class WeekWeatherDataMapper @Inject constructor() {

     fun map(responses: List<WeekWeatherResponse>): List<WeekWeatherDataModel> {
         return responses.map (::mapToModel)
     }

    private fun mapToModel(responses: WeekWeatherResponse): WeekWeatherDataModel {
        return WeekWeatherDataModel(
            day = responses.weekday,
            temperature = responses.temperature,
            weatherConditions = responses.weatherConditions
        )
    }
}