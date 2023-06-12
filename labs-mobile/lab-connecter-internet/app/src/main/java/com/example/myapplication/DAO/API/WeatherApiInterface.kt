package com.example.myapplication.DAO.API

import com.example.myapplication.models.Weather
import retrofit2.http.GET
import retrofit2.http.Path


interface WeatherApiInterface {
    @GET("getApi/{name}")
    suspend fun getWeatherInterface(@Path("name") name :String): Weather


}
