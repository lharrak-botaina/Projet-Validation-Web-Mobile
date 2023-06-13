package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Context
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
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWeatherBinding
import com.example.myapplication.models.SaveWeather
import com.example.myapplication.models.Weather
import com.example.myapplication.utils.Status
import prototype.todolist.ui.BaseFragment
import kotlin.math.log

class WeatherFragment  : BaseFragment<FragmentWeatherBinding>(FragmentWeatherBinding::inflate) {


    private val viewModel: WeatherViewModel by viewModels()
    var city:String  =""
    var userId:Int  =0
    var idCity:Int  =0
    var iconWeather:String  =""
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
        val prefs = requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
         userId = prefs.getInt("userId", 0)
        Log.d("userId", userId.toString())


    }

    @SuppressLint("SuspiciousIndentation")
    override fun listeners(view: View) {
        binding.apply {
            btnSearsh.setOnClickListener {
                var name = input.text.toString()
                Log.d("name city", name)
                viewModel.getWeather(name).observe(viewLifecycleOwner, Observer {

                    when (it.status) {
                        Status.LOADING ->showProgressBar()
                        Status.ERROR -> showResponseError(it.message.toString())
                        Status.SUCCESS -> {
                            idCity = it.data?.id_city!!
                             city =   it.data?.city.toString()
                            forecast = it.data?.main.toString()
                            temp =it.data?.temp.toString()
                            country=it.data?.country.toString()
                            humidity = it.data?.humidity.toString()
                            description=it.data?.description.toString()
                            iconWeather = it.data?.icon.toString()
                            cityName.text = it.data?.city

                            context?.let { it1 ->
                                Glide
                                    .with(it1)
                                    .load("https://openweathermap.org/img/wn/"+iconWeather+"@2x.png")
                                    .into(icon)
                            };
                    Toast.makeText(context, "showing.", Toast.LENGTH_SHORT).show()
                            }
                        }

                })

            }

            saveBtn.setOnClickListener {
                Log.d("dddd", city)
                Log.d("dddd", idCity.toString())
                var save =  SaveWeather(idCity,city,userId)
                viewModel.SaveWeather(save).observe(viewLifecycleOwner, Observer {
                    when (it.status) {
                        Status.LOADING -> showProgressBar()
                        Status.ERROR -> showResponseError(it.message.toString())
                        Status.SUCCESS -> {
//                            binding.btnFavorite.visibility = View.INVISIBLE
//                            binding.btnRemoveFavorite.visibility = View.VISIBLE
//                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "The league has been added to favorites.", Toast.LENGTH_SHORT).show()

                        }
                    }
                })
            }
        }
    }


}