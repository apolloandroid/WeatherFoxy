package space.riri.weatherfoxy.data.repo


import android.annotation.SuppressLint
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.viewmodel.CreationExtras.Empty.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import space.riri.weatherfoxy.data.api.services.ApiService
import space.riri.weatherfoxy.data.mapper.HourlyWeatherDataMapper
import space.riri.weatherfoxy.data.mapper.TodayWeatherDataMapper
import space.riri.weatherfoxy.data.mapper.WeekWeatherDataMapper
import space.riri.weatherfoxy.data.model.HourlyWeatherDataModel
import space.riri.weatherfoxy.data.model.TodayWeatherDataModel
import space.riri.weatherfoxy.data.model.WeekWeatherDataModel

class WeatherRepositoryImpl (
    private val service : ApiService,
    private val hourlyMapper: HourlyWeatherDataMapper,
    private val todayMapper: TodayWeatherDataMapper,
    private val weekMapper: WeekWeatherDataMapper
) : WeatherRepository {

    @SuppressLint("SuspiciousIndentation")
    override suspend fun getHourlyWeather() : Flow<List<HourlyWeatherDataModel>> {
        val response = service.getHourlyWeather()

           return HourlyWeatherDataModel.map(response)


    }

    override fun getTodayWeather() : Flow<TodayWeatherDataModel> {
        return flow {
            val response = service.getToDayWeather()
            val model = todayMapper.map(response)
            emit(model)
        }
    }

    override fun getWeekWeather(): Flow<List<WeekWeatherDataModel>> {
        return flow {
            val response = service.getWeekWeather()
            val model = weekMapper.map(response)
            emit(model)
        }
    }
}