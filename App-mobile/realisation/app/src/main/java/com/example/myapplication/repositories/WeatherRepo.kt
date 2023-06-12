package com.example.myapplication.repositories

import com.example.myapplication.DAO.WeatheDAO
import com.example.myapplication.models.SaveWeather
import com.example.myapplication.models.User

class WeatherRepo {
    private val tasksDao = WeatheDAO()

    suspend fun getWeatherRepo(name :String) = tasksDao.getWeatherDAO(name)
    suspend fun delete(id :Int) = tasksDao.deleteDAO(id)
    suspend fun getSaveWeatherRepo(id: Int) = tasksDao.getSaveWeatherDAO(id)
    suspend fun saveWeatherRepo(Weather : SaveWeather) = tasksDao.saveWeatherDAO(Weather)
    suspend fun login(user: User) = tasksDao.login(user)
}