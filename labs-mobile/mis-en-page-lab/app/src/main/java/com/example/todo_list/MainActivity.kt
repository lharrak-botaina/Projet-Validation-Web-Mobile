package com.example.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_list.data.TaskRepository
import com.example.todo_list.databinding.ActivityMainBinding
import com.example.todo_list.ui.TaskAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //is used to convert the XML file that defines the layout of the main activity into a Kotlin object that you can use in your code.
        //contains references to all the views in the layout
        val binding = ActivityMainBinding.inflate(layoutInflater)
        /*
         - setContentView : it means that you are telling the Android system to display the layout
          that you just inflated on the screen as the content view
        - binding.root :each layout has a root view,telling Android to display the entire layout on the screen.
        */
        setContentView(binding.root)
        binding.apply {
            val taskAdapter = TaskAdapter()
//       -applicationContext parameter is a reference to the application context
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = taskAdapter
            floatingActionButton.setOnClickListener{
                println("hh")
        val repository = TaskRepository()
            val newTask = repository.newTask()
            newTask.title ="new task"+ Random.nextInt()
            repository.save(newTask)
            Toast.makeText(applicationContext,"ajouter une tache",Toast.LENGTH_LONG).show()
            taskAdapter.notifyDataSetChanged()
        }
        }

    }

}