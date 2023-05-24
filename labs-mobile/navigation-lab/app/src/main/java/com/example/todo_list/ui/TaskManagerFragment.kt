package com.example.todo_list.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.R
import com.example.todo_list.data.TaskRepository
import com.example.todo_list.databinding.FragmentTaskManagerBinding
import kotlin.random.Random




class TaskManagerFragment : Fragment() {

    private var _binding: FragmentTaskManagerBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter : TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentTaskManagerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        this.taskAdapter =  TaskAdapter(view.findNavController())
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =  taskAdapter
            floatingActionButton.setOnClickListener{
                val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToFormFragment(taskid = 0 )
                view.findNavController().navigate(action)
            }


        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    binding.apply {
//        val taskAdapter = TaskAdapter()
////       -applicationContext parameter is a reference to the application context
//        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
//        recyclerView.adapter = taskAdapter
//        floatingActionButton.setOnClickListener{
//            println("hh")
//            val repository = TaskRepository()
//            val newTask = repository.newTask()
//            newTask.title ="new task"+ Random.nextInt()
//            repository.save(newTask)
//            Toast.makeText(applicationContext,"ajouter une tache", Toast.LENGTH_LONG).show()
//            taskAdapter.notifyDataSetChanged()
//        }
//    }

}