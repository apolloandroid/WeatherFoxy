package space.riri.weatherfoxy.data.repo

import space.riri.weatherfoxy.data.model.HourlyWeatherDataModel
import space.riri.weatherfoxy.data.model.TodayWeatherDataModel
import space.riri.weatherfoxy.data.model.WeekWeatherDataModel

interface WeatherRepository {

    suspend fun getHourlyWeather() : List<HourlyWeatherDataModel>

    suspend fun getTodayWeather() : TodayWeatherDataModel

    suspend fun getWeekWeather() : List<WeekWeatherDataModel>
}