package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private lateinit var appBarConfiguration : AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        var navigationController = this.findNavController(R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this , navigationController)

        appBarConfiguration = AppBarConfiguration(navigationController.graph)

    }

    override fun onSupportNavigateUp(): Boolean {
        val nav_controller = this.findNavController(R.id.fragmentContainerView)
        /*if (nav_controller.currentDestination?.id == R.id.addShoeFragment) {
            Toast.makeText(applicationContext, "Shoe is not saved !! ", Toast.LENGTH_SHORT).show()
        } else if (nav_controller.currentDestination?.id == R.id.loginFragment) {
            finish()
        }
        return NavigationUI.navigateUp(nav_controller, appBarConfiguration) || super.onSupportNavigateUp()*/
        return nav_controller.navigateUp()

    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp()
//    }
//
//    override fun onBackPressed() {
//        super.onSupportNavigateUp()
//    }
}
