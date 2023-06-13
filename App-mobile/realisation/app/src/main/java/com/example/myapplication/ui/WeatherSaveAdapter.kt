package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.NavController

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.SaveWeather
import com.example.myapplication.repositories.WeatherRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherSaveAdapter (private val weather: ArrayList<SaveWeather>, navController: NavController)
    : RecyclerView.Adapter<WeatherSaveAdapter.DataViewHolder>() {

        val repo = WeatherRepo()
    private val navController = navController

    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val city : TextView = view.findViewById(R.id.cityName)

        val removeBtn : TextView = view.findViewById<Button>(R.id.btnRemove)
        val cardView: CardView = view.findViewById(R.id.cardview)

        fun bind(weather : SaveWeather) {
            city.text = weather.city

        }
    }

    // for convert league_items xml to view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_weather_save, parent, false)
        return DataViewHolder(layout)
    }

    //for determine number of items shuld be displayed
    override fun getItemCount(): Int  = weather.size



    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val Weather = weather[position]
        holder.bind(Weather)
        holder.cardView.setOnClickListener{
        val action =WeathetSaveFragmentDirections.actionWeathetSaveFragmentToWeatherShowFragment2(Weather.id,Weather.city)
            navController.navigate(action)
        }



        holder.removeBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {


                repo.delete(Weather.id)
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        holder.itemView.context,
                        "Deleted from the favorite",
                        Toast.LENGTH_SHORT
                    ).show()
                    weather.removeAt(position) // Remove the task from the list
                    notifyItemRemoved(position)
                }
            }
        }


    }

    // this methode  used for clear data in the list and add new data for displaying
    fun addWeather(Weather:List<SaveWeather>) {
        this.weather.apply {
            clear()
            addAll(Weather)
        }
    }




}