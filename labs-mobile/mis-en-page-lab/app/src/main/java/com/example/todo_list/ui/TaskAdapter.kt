package com.example.todo_list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.R
import com.example.todo_list.data.TaskRepository

class TaskAdapter():RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
    private val taskRepository = TaskRepository()
    class TaskViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val taskTitle:TextView = view.findViewById<Button>(R.id.taskTitle)
        val taskPriority : TextView = view.findViewById<Button>(R.id.taskPriority)
        val taskTimestamp :TextView = view.findViewById(R.id.taskTimestamp)
        val cardView :CardView= view.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(layout)
    }

    override fun onBindViewHolder(taskViewHolder: TaskViewHolder, position: Int) {
        val task = this.taskRepository.getAllTasks()[position]
        taskViewHolder.taskTitle.text = task.title
        taskViewHolder.taskPriority.text= task.priority.toString()

        taskViewHolder.taskTimestamp.text = task.timestamp.toString()
    }

    override fun getItemCount(): Int {
        return taskRepository.getAllTasks().size
    }

}