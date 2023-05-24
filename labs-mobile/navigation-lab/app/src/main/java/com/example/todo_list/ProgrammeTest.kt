package com.example.todo_list

import com.example.todo_list.data.TaskEntry
import com.example.todo_list.data.TaskRepository

fun main(){
    val taskRepository = TaskRepository()
   // Ajouter une tache
//    val task1 = TaskEntry(0,"task 1",1,System.currentTimeMillis())
//    val task2 = TaskEntry(1,"Task 1",1,System.currentTimeMillis())

//    taskRepository.save(task1)
//    println(task1.title)

//============================================================


    val taskDisplay = taskRepository.getAllTasks()
    //explain data class :
    // println(task1.equals(task2)) //=> True if we have data class, but if we have simple class, it's false because: passed by reference

//============================================================


//     Suprimer une tâche

//   val taskDelete = taskRepository.delete(1)
//    if(taskDelete !=null){
//        println("deleted")
//    }


//============================================================


    //afficher task
    fun display(){
        var displayTasks = taskRepository.getAllTasks()
        for (item in displayTasks){
            println(item.title)

        }
    }
    //display()

//============================================================

    
    // modifier task
    val titleId = taskRepository.findById(1)
    titleId.title="Tiiiiii"
    taskRepository.save(titleId)
    //display()

}