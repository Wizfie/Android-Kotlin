package com.example.barvolume

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.barvolume.databinding.ActivityPageThreeBinding

class PageThree : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    private lateinit var binding: ActivityPageThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvData = binding.tvDataReceived

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name : $name, Your Age : $age"
        tvData.text = text
    }
}