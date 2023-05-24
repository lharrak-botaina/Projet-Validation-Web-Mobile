package com.example.todo_list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.R
import com.example.todo_list.data.TaskRepository
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(navController: NavController):RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
    private val taskRepository = TaskRepository()
    private val navController = navController
    class TaskViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val taskTitle:TextView = view.findViewById<Button>(R.id.taskTitle)
        val taskPriority : TextView = view.findViewById<Button>(R.id.taskPriority)
        val taskTimestamp :TextView = view.findViewById(R.id.taskTimestamp)
        val cardView :CardView= view.findViewById(R.id.cardview)
        val priorityArray : Array<String> = view.resources.getStringArray(R.array.priorities)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(layout)
    }

    override fun onBindViewHolder(taskViewHolder: TaskViewHolder, position: Int) {
        val task = this.taskRepository.getAllTasks()[position]
        taskViewHolder.taskTitle.text = task.title
        if(task.priority.equals(1)){
            taskViewHolder.taskPriority.text = taskViewHolder.priorityArray[0]
        }else if (task.priority.equals(2)){
            taskViewHolder.taskPriority.text = taskViewHolder.priorityArray[1]
        }else{
            taskViewHolder.taskPriority.text = taskViewHolder.priorityArray[2]
        }
//        taskViewHolder.taskPriority.text= task.priority.toString()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()) // Define the date format
        val formattedDate = dateFormat.format(Date(task.timestamp)) // Format the date
        taskViewHolder.taskTimestamp.text = formattedDate
        taskViewHolder.cardView.setOnClickListener {

         var action = TaskManagerFragmentDirections.actionTaskManagerFragmentToFormFragment(taskid = 0 )
            navController.navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return taskRepository.getAllTasks().size
    }


}