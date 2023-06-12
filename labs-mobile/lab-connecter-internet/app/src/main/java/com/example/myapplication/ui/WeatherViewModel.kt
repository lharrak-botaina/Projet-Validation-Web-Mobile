package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.repositories.WeatherRepo
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.Dispatchers

class WeatherViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val weatherRepository = WeatherRepo()

    fun getWeather(name :String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = weatherRepository.getWeatherRepo(name)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}