package com.example.todo_list.data

class TaskDao {
    companion object{
     private var taskCount =0
        private var listTasks = mutableListOf<TaskEntry>()
        init {
            for (i in 1..10){
                listTasks.add(TaskEntry(i,"task $i",1,System.currentTimeMillis()))
            }
        }
    }
    fun insert(taskEntry: TaskEntry){
        taskEntry.id=++TaskDao.taskCount
        TaskDao.listTasks.add(0,taskEntry)
    }
    fun delete(id:Int){
        var index=this.findIndexId(id)
        listTasks.removeAt(index)


    }
    private fun findIndexId(id:Int):Int{
        val index =TaskDao.listTasks.withIndex().filter { it.value.id == id }.map { it.index }.first()
        return index
    }
    // Another method of delet using indexOfFirst
//    fun deleteTask(id: Int){
//        val index = listTasks.indexOfFirst { it.id.equals(id) }
//        if(index != -1){
//            listTasks.removeAt(index)
//        }
//    }

    fun getAllTasks():MutableList<TaskEntry>{
        return TaskDao.listTasks
    }
    fun findById(id:Int) : TaskEntry{
        val task = TaskDao.listTasks.filter { it.id == id }.first()
        return task
    }
    fun update(taskEntry: TaskEntry){
        var index = this.findIndexId(taskEntry.id)
        TaskDao.listTasks[index] = taskEntry
    }
}