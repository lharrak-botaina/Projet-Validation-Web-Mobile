package prototype.todolist.ui

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import prototype.todolist.R
import prototype.todolist.models.Task
import prototype.todolist.databinding.FragmentTaskFormBinding
import prototype.todolist.databinding.FragmentWeatherBinding
import prototype.todolist.utils.Status

class WeatherFragment : BaseFragment<FragmentWeatherBinding>(FragmentWeatherBinding::inflate) {

    private val viewModel: TaskViewModel by viewModels()
    private var taskId =  0 // La valeur 0 signifie que le formulaire est dans l'état d'insertion
    private  var task : Task? = null

    override fun init(view: View) {



        this.setProgressBar(R.id.progressBar)





    }

    override fun listeners(view: View) {
        binding.apply {
            btnSearch.setOnClickListener {
                Log.d("ddddddddd", "listeners: dddddddddd")

            }
        }
    }


}
