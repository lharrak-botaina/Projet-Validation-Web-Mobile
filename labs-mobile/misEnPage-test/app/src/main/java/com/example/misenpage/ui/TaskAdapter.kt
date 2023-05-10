package com.example.misenpage.ui

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.misenpage.R
import com.example.misenpage.data.TaskRepository

class TaskAdapter (): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val  taskRepository = TaskRepository()
    class TaskViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val taskTitle:TextView=view.findViewById<Button>(R.id.taskTitle)
        val taskPriority:TextView = view.findViewById<Button>(R.id.taskPriority)
        val taskTimestamp:TextView=view.findViewById<Button>(R.id.taskTimestamp)
        val cardView:CardView=view.findViewById(R.id.cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}