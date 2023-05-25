package prototype.todolist.ui


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import prototype.todolist.R
import prototype.todolist.databinding.FragmentTaskManagerBinding


class TaskManagerFragment : Fragment() {

    private var _binding: FragmentTaskManagerBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter : TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

// The onCreateView() function inflates the layout for the fragment and returns the root view.
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



    //The onViewCreated() function sets up the RecyclerView to display the list of tasks and sets a click listener on the "Add" button to navigate to the TaskFormFragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        this.taskAdapter =  TaskAdapter(view.findNavController())
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =  taskAdapter
            floatingActionButton.setOnClickListener{
                val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTaskFormFragment(taskid = 0 )
                view.findNavController().navigate(action)
            }

        }


    }

    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Todo : Implémentez le code du button Ajouter une tâche dans le menu
    //The onCreateOptionsMenu() function inflates the menu layout for the fragment.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_add -> {
                val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTaskFormFragment(taskid = 0)
                recyclerView.findNavController().navigate(action)
                true
            }
            R.id.item_menu_test -> {
                val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTestFragment()
                recyclerView.findNavController().navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }





}