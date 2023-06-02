package com.example.myapplication.DAO.API

import com.example.myapplication.models.Weather
import retrofit2.http.GET


interface WeatherApiInterface {
    @GET("getApi")
    suspend fun getWeatherInterface(): List<Weather>


}
