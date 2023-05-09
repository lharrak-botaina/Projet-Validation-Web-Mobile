package prototype.todolist

import prototype.todolist.data.TaskDao
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository

fun main (){

    val taskRepository = TaskRepository()
    // Ajouter une tâche
    val task1 = TaskEntry(0,"Task 12",1,System.currentTimeMillis())
//    val task2 = TaskEntry(1,"Task 1",1,System.currentTimeMillis())
    taskRepository.save(task1);
    println(task1.title)



    val taskDisplay = taskRepository.getAllTasks()
    //explain data class :
    // println(task1.equals(task2)) //=> True if we have data class, but if we have simple class, it's false because: passed by reference




//     Suprimer une tâche

//    val taskDelete = taskRepository.delete(1)

//test
    // Modifier une tâche
    val titleUp = taskRepository.findById(1)
    titleUp.title = "Title 1"
    taskRepository.save(titleUp)

    // Afficher les tâches
    for (item in taskDisplay){
        println(item.title)
    }

}