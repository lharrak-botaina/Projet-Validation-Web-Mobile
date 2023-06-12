package com.example.myapplication.ui
import android.content.Context
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentWeatherBinding
import com.example.myapplication.databinding.FragmentWeatherSaveListBinding
import com.example.myapplication.utils.Status


import prototype.todolist.ui.BaseFragment


class WeathetSaveFragment : BaseFragment<FragmentWeatherSaveListBinding>(FragmentWeatherSaveListBinding::inflate) {

    private  val viewModel: WeatherViewModel by viewModels()
    private lateinit var adapter: WeatherSaveAdapter

    override fun init(view: View) {
        val prefs = requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val userId = prefs.getInt("userId", 0)
        Log.d("userId", userId.toString())

        adapter =  WeatherSaveAdapter(arrayListOf(), view.findNavController() )
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =  adapter


        }

        // getUsers observe
        viewModel.getSaveWeather(userId).observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> this.showProgressBar()
                Status.ERROR -> this.showResponseError(it.message.toString())
                Status.SUCCESS -> {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    adapter.apply {
                        addWeather( it.data!!)
                        notifyDataSetChanged()
                    }
                }
            }
        })


    }

    override fun listeners(view: View) {

    }


}