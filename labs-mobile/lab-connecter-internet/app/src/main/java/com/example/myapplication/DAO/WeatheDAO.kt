package com.example.myapplication.DAO

import com.example.myapplication.DAO.API.WeatherApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatheDAO {

    companion object{

        private var BASE_URL = "http://192.168.2.53:8000/api/"

        // it a Gson library use  it for get api and convert json to object
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() //Doesn't require the adapter
        }
        //specify the interface that should be used to define the API
        val apiService: WeatherApiInterface = getRetrofit().create(WeatherApiInterface::class.java)
    }

    suspend fun getWeatherDAO(name : String) = apiService.getWeatherInterface(name)
}