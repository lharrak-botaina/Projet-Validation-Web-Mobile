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
            viewModel.getWeather().observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Status.LOADING -> this.showProgressBar()
                    Status.ERROR -> this.showResponseError(it.message.toString())
                    Status.SUCCESS -> {
                        this.hideProgressBar()
                        binding.apply {
                            weathere = it.data!!
                            cityName.text= weathere?.city

                        }
                    }
                }
            })




    }

    override fun listeners(view: View) {
        binding.apply {
            btnSave.setOnClickListener {
                if(TextUtils.isEmpty(editTaskTitle.text)){
                    Toast.makeText(context, "It's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val taskTitle = editTaskTitle.text.toString()
                val priority = spinner.selectedItemPosition
                val task = Task(
                    taskId,
                    taskTitle,
                    priority,
                    task?.timestamp!!

                )

                viewModel.save(task).observe(viewLifecycleOwner, Observer {
                    when (it.status) {
                        Status.LOADING -> showProgressBar()
                        Status.ERROR -> showResponseError(it.message.toString())
                        Status.SUCCESS -> {
                            binding.form.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
                            val action = TaskFormFragmentDirections.actionTaskFormFragmentToTaskManagerFragment()
                            view.findNavController().navigate(action)
                        }
                    }
                })
//


            }
            btnDelete.setOnClickListener {
                viewModel.delete(taskId).observe(viewLifecycleOwner, Observer {
                    when (it.status) {
                        Status.LOADING -> showProgressBar()
                        Status.ERROR -> showResponseError(it.message.toString())
                        Status.SUCCESS -> {
                            binding.form.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(activity, "${task?.title} : Deleted", Toast.LENGTH_LONG).show()
                        }
                    }
                })
                val action = TaskFormFragmentDirections.actionTaskFormFragmentToTaskManagerFragment()
                view.findNavController().navigate(action)
            }
        }

    }
}