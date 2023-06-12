package com.example.myapplication.DAO.API

import com.example.myapplication.models.SaveWeather
import com.example.myapplication.models.User
import com.example.myapplication.models.Weather
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface WeatherApiInterface {
    @GET("witherApi/{name}")
    suspend fun getWeatherInterface(@Path("name") name :String): Weather


    @DELETE("delete/{id}")
    suspend fun deleteInterface(@Path("id") id :Int): Int


    @GET("SaveList/{user_id}")
    suspend fun getSaveWeatherInterface(@Path("user_id") id :Int): List<SaveWeather>

    @POST("SaveCity")
    suspend fun saveWeatherInterface(@Body Weather : SaveWeather): Int

  @POST("Login")
    suspend fun login(@Body user: User): User

}
