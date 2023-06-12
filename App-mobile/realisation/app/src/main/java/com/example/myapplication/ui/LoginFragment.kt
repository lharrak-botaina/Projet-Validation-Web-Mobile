package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentWeatherBinding
import com.example.myapplication.models.User
import com.example.myapplication.utils.Status
import prototype.todolist.ui.BaseFragment
import prototype.todolist.ui.Inflater

class LoginFragment  : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate)
{



        var idUser : Int = 0
    private val viewModel: WeatherViewModel by viewModels()
    override fun init(view: View) {

    }

    @SuppressLint("SuspiciousIndentation")
    override fun listeners(view: View) {
        binding.apply {
        loginBtn.setOnClickListener {
            var emailInput = email.text.toString()
            var passwordInput = password.text.toString()
            var user = User(
                idUser,emailInput,passwordInput
            )
            viewModel.login(user).observe(viewLifecycleOwner, Observer {

                when (it.status) {
                    Status.LOADING ->showProgressBar()
                    Status.ERROR -> showResponseError(it.message.toString())
                    Status.SUCCESS -> {
                        Log.d("email respons", it.data?.email.toString())
                        val userId =  it.data?.id
                        val prefs = requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

                        if (userId != null) {
                            prefs.edit().putInt("userId", userId).apply()
                        }

                        binding.email.setText("")
                        binding.password.setText("")

                            val action = LoginFragmentDirections.actionLoginFragmentToWeatherFragment()
                                findNavController().navigate(action)
                        Toast.makeText(context, "showing.", Toast.LENGTH_SHORT).show()
                    }
                }

            })
        }
        }
    }

}