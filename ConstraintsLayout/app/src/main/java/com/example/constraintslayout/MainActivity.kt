package com.example.constraintslayout

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.constraintslayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonApply.setOnClickListener {
            val Firstname = binding.firstname.text.toString()
            val Lastname = binding.lastname.text.toString()
            val Birthdate = binding.birthdate.text.toString()
            val Country = binding.country.text.toString()

            Log.d("MainActivity" ,"$Firstname")
            Log.d("MainActivity" ,"$Lastname")
            Log.d("MainActivity" ,"Born on + $Birthdate")
            Log.d("MainActivity" ,"From + $Country")
        }

    }
}