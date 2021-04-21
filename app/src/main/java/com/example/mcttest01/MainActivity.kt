package com.example.mcttest01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mcttest01.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.transition.MaterialElevationScale

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    lateinit var bt: FloatingActionButton
    val mFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.fragment)
            ?.childFragmentManager
            ?.fragments
            ?.first()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var bt = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        bt.setOnClickListener{
            mFragment?.apply {
                exitTransition = MaterialElevationScale(false).apply {
                    duration = 500
                }
                reenterTransition = MaterialElevationScale(true).apply {
                    duration = 500
                }
            }
            val direction = Nav2()
            findNavController(R.id.fragment).navigate(direction)
        }

//        binding.floatingActionButton.setOnClickListener {
//            mFragment?.apply {
//                exitTransition = MaterialElevationScale(false).apply {
//                    duration = 500
//                }
//                reenterTransition = MaterialElevationScale(true).apply {
//                    duration = 500
//                }
//
//                val direction = Nav2()
//                findNavController(R.id.fragment).navigate(direction)
//            }
//        }
    }
}