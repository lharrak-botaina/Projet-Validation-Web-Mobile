package com.example.myapplication.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWeatherBinding
import com.example.myapplication.models.Weather
import com.example.myapplication.utils.Status
import prototype.todolist.ui.BaseFragment

class WeatherFragment  : BaseFragment<FragmentWeatherBinding>(FragmentWeatherBinding::inflate) {

    companion object {
        val TASKID = "taskid" // Il resemble à une variable static
    }

    private val viewModel: WeatherViewModel by viewModels()
    private var weatherId =  0 // La valeur 0 signifie que le formulaire est dans l'état d'insertion
    private  var weathere : Weather? = null

    override fun init(view: View) {

//        this.setProgressBar(R.id.progressBar)


        // Call : FindById
//            viewModel.getWeather().observe(viewLifecycleOwner, Observer {
//                when (it.status) {
//                    Status.LOADING -> this.showProgressBar()
//                    Status.ERROR -> this.showResponseError(it.message.toString())
//                    Status.SUCCESS -> {
//                        this.hideProgressBar()
//                        binding.apply {
//                         cityName.text = it.data?.city
//                            weathere = it.data!!
//
//
//                        }
//                    }
//                }
//            })




    }

    override fun listeners(view: View) {//            btnSearch.setOnClickListener {
//                var name = inputSearch.text.toString()
//                viewModel.getWeather(name).observe(viewLifecycleOwner, Observer {
//
//                                cityName.text = it.data?.city
//                                weathere = it.data!!
//
//
//
//
//
//
//                })
//            }
        binding.apply {

        }
    }


}