package space.riri.weatherfoxy.data.api.services

import retrofit2.http.GET
import space.riri.weatherfoxy.data.api.response.HourlyWeatherResponse
import space.riri.weatherfoxy.data.api.response.TodayWeatherResponse
import space.riri.weatherfoxy.data.api.response.WeekWeatherResponse


interface ApiService {

    @GET("weather/day/hourly")
    suspend fun getHourlyWeather() : List<HourlyWeatherResponse>

    @GET("weather/today")
    suspend fun getToDayWeather() : TodayWeatherResponse

    @GET("weather/week")
    suspend fun getWeekWeather() : List<WeekWeatherResponse>
}