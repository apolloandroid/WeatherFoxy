package space.riri.weatherfoxy.data.mapper

import space.riri.weatherfoxy.data.api.response.TodayWeatherResponse
import space.riri.weatherfoxy.data.model.TodayWeatherDataModel
import javax.inject.Inject

class TodayWeatherDataMapper @Inject constructor() {

     fun map(responses: TodayWeatherResponse): TodayWeatherDataModel {
        return TodayWeatherDataModel(
            date = responses.date,
            day = responses.day,
            month = responses.month,
            temperature = responses.temperature,
            weatherConditions = responses.weatherConditions
        )
    }
}