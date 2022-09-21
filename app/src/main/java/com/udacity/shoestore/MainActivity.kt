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
        return nav_controller.navigateUp()

    }



}
