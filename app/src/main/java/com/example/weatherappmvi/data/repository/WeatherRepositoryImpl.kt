package com.example.weatherappmvi.data.repository

import com.example.weatherappmvi.data.mapper.toWeatherInfo
import com.example.weatherappmvi.data.remote.WeatherApi
import com.example.weatherappmvi.domain.repository.WeatherRepository
import com.example.weatherappmvi.domain.util.Resource
import com.example.weatherappmvi.domain.weather.WeatherInfo
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = weatherApi.getWeatherData(
                    lat = lat, long = long
                ).toWeatherInfo()
            )

        }catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}