package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.WeatherFragmentDirections

            class MainActivity : AppCompatActivity() {

                private lateinit var navController: NavController
                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)

                    val binding = ActivityMainBinding.inflate(layoutInflater)
                    setContentView(binding.root)

                    // Get the navigation host fragment from this Activity
                    val navHostFragment = supportFragmentManager
                        .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                    // Instantiate the navController using the NavHostFragment
                    navController = navHostFragment.navController
                    // Make sure actions in the ActionBar get propagated to the NavController
                    setupActionBarWithNavController(navController)

                }
                    override fun onCreateOptionsMenu(menu: Menu): Boolean {
                        menuInflater.inflate(R.menu.layout_menu, menu)
                        return true
                    }

                    override fun onOptionsItemSelected(item: MenuItem): Boolean {
                        when (item.itemId) {
                            R.id.save_item -> {
                                val action =
                                    WeatherFragmentDirections.actionWeatherFragmentToWeathetSaveFragment()
                                navController.navigate(action)
                                return true
                            }
                            else -> return super.onOptionsItemSelected(item)
                        }
                    }
                override fun onSupportNavigateUp(): Boolean {
                    return navController.navigateUp() || super.onSupportNavigateUp()
                }
}