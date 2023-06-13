package com.example.myapplication.ui

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWeatherBinding
import com.example.myapplication.databinding.FragmentWeatherShowBinding
import com.example.myapplication.models.SaveWeather
import com.example.myapplication.models.Weather
import com.example.myapplication.utils.Status
import prototype.todolist.ui.BaseFragment
import kotlin.math.log

class WeatherShowFragment  : BaseFragment<FragmentWeatherShowBinding>(FragmentWeatherShowBinding::inflate) {


    private val viewModel: WeatherViewModel by viewModels()
var city:String  =""
var iconWeather:String  =""
var idCity:Int  =0
    var forecast : String=""
    var temp : String=""
    var time : String=""
    var   country : String=""
    var  humidity : String=""
    var   min_temp : String=""
    var  tem_up : String=""
    var  sunrises : String=""
    var sunsets : String=""
    var description : String=""

    override fun init(view: View) {

        binding.apply {
            arguments.let {
                if (it != null) {
                    city = it.getString("cityName", " ")
                    idCity = it.getInt("idCity", 0)

                }

            }
//        this.setProgressBar(R.id.progressBar)


            // Call : FindById
            viewModel.getWeather(city).observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Status.LOADING -> showProgressBar()
                    Status.ERROR -> showResponseError(it.message.toString())
                    Status.SUCCESS -> {

                        binding.apply {
                            cityName.text = it.data?.city
                            iconWeather = it.data?.icon.toString()
                            forecast = it.data?.main.toString()
                            temp =it.data?.temp.toString()
                            country=it.data?.country.toString()
                            humidity = it.data?.humidity.toString()
                            description=it.data?.description.toString()

                            context?.let { it1 ->
                                Glide
                                    .with(it1)
                                    .load("https://openweathermap.org/img/wn/"+iconWeather+"@2x.png")
                                    .into(icon)
                            };
                        }
                    }
                }
            })

        }

    }

    override fun listeners(view: View) {
        binding.deleteBtn.setOnClickListener {

            viewModel.delete(idCity).observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Status.LOADING -> showProgressBar()
                    Status.ERROR -> showResponseError(it.message.toString())
                    Status.SUCCESS -> {

                       val action = WeatherShowFragmentDirections.actionWeatherShowFragmentToWeathetSaveFragment2()
                        findNavController().navigate(action)
                    }
                }
            })
        }
    }

}