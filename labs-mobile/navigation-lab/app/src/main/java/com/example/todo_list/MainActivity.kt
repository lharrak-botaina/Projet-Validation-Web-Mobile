package com.example.todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_list.data.TaskRepository
import com.example.todo_list.databinding.ActivityMainBinding
import com.example.todo_list.ui.TaskAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
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

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }
    /**
     * Enables back button support. Simply navigates one element up on the stack.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}