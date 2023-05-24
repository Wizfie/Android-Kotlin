package com.example.barvolume

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.barvolume.databinding.ActivityPageFourBinding

class PageFour : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    private  lateinit var binding: ActivityPageFourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvObject = binding.tvObjectReceived

        val person = if (Build.VERSION.SDK_INT >= 33 ){
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)

        }
        if (person != null ){
            val data = "Name : ${person.name.toString()}, \nEmail : ${person.email.toString()}, \nAge : ${person.age.toString()}, \nLocation : ${person.city.toString()}"
            tvObject.text = data
        }

    }
}