package com.example.myapplication.repositories

import com.example.myapplication.DAO.WeatheDAO

class WeatherRepo {
    private val tasksDao = WeatheDAO()

    suspend fun getWeatherRepo(name :String) = tasksDao.getWeatherDAO(name)
}