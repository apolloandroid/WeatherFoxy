package space.riri.weatherfoxy.data.repo

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import space.riri.weatherfoxy.data.api.services.ApiService
import space.riri.weatherfoxy.data.mapper.HourlyWeatherDataMapper
import space.riri.weatherfoxy.data.mapper.TodayWeatherDataMapper
import space.riri.weatherfoxy.data.mapper.WeekWeatherDataMapper
import space.riri.weatherfoxy.data.model.HourlyWeatherDataModel
import space.riri.weatherfoxy.data.model.TodayWeatherDataModel
import space.riri.weatherfoxy.data.model.WeekWeatherDataModel

class WeatherRepositoryImpl(
    private val service: ApiService,
    private val hourlyMapper: HourlyWeatherDataMapper,
    private val todayMapper: TodayWeatherDataMapper,
    private val weekMapper: WeekWeatherDataMapper
) : WeatherRepository {

    override suspend fun getHourlyWeather(): List<HourlyWeatherDataModel> {
        return withContext(IO) {
            val response = service.getHourlyWeather()
            val model = hourlyMapper.map(response)
            model
        }
    }

    override suspend fun getTodayWeather(): TodayWeatherDataModel {
        return withContext(IO) {
            val response = service.getToDayWeather()
            val model = todayMapper.map(response)
            model
        }
    }

    override suspend fun getWeekWeather(): List<WeekWeatherDataModel> {
        return withContext(IO) {
            val response = service.getWeekWeather()
            val model = weekMapper.map(response)
            model
        }
    }
}