package space.riri.weatherfoxy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.riri.weatherfoxy.data.api.services.ApiService
import space.riri.weatherfoxy.data.mapper.HourlyWeatherDataMapper
import space.riri.weatherfoxy.data.mapper.TodayWeatherDataMapper
import space.riri.weatherfoxy.data.mapper.WeekWeatherDataMapper
import space.riri.weatherfoxy.data.repo.WeatherRepository
import space.riri.weatherfoxy.data.repo.WeatherRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Singleton
    @Provides
    fun provideHourlyDataMapper(): HourlyWeatherDataMapper = HourlyWeatherDataMapper()

    @Singleton
    @Provides
    fun provideTodayDataMapper(): TodayWeatherDataMapper = TodayWeatherDataMapper()

    @Singleton
    @Provides
    fun provideWeekDataMapper(): WeekWeatherDataMapper = WeekWeatherDataMapper()

    @Singleton
    @Provides
    fun providesRepository(
        apiService: ApiService,
        hourlyMapper: HourlyWeatherDataMapper,
        todayMapper: TodayWeatherDataMapper,
        weekMapper: WeekWeatherDataMapper
    ) : WeatherRepository = WeatherRepositoryImpl(
        apiService,
        hourlyMapper,
        todayMapper,
        weekMapper
    )
}