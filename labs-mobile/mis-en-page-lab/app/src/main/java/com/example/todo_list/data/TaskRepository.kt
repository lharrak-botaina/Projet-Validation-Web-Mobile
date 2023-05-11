package com.example.todo_list.data

class TaskRepository {
    private val taskDao = TaskDao()
    private fun insert(taskEntry: TaskEntry)=taskDao.insert(taskEntry)
    fun delete(taskId:Int)=taskDao.delete(taskId)
    fun getAllTasks() = taskDao.getAllTasks()
    fun findById(id:Int) = taskDao.findById(id)
    private fun update(taskEntry: TaskEntry)=taskDao.update(taskEntry)
    fun newTask():TaskEntry{
        return TaskEntry(0,"",0,System.currentTimeMillis())
    }
    fun save(taskEntry: TaskEntry){
        if (taskEntry.id.equals(0)){
            this.insert(taskEntry)
        }else{
           this.update(taskEntry)
        }
    }
}