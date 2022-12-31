package space.riri.weatherfoxy.data.repo

import kotlinx.coroutines.flow.Flow
import space.riri.weatherfoxy.data.model.HourlyWeatherDataModel
import space.riri.weatherfoxy.data.model.TodayWeatherDataModel
import space.riri.weatherfoxy.data.model.WeekWeatherDataModel

interface WeatherRepository {

    suspend fun getHourlyWeather() : Flow<List<HourlyWeatherDataModel>>

    fun getTodayWeather() : Flow<TodayWeatherDataModel>

    fun getWeekWeather() : Flow<List<WeekWeatherDataModel>>
}