package com.example.mybooks

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mybooks.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail Book"


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra("key_name")
        val description = intent.getStringExtra("key_description")
        val images = intent.getStringExtra("key_images")

        binding.detailNamaBuku.text = name
        binding.detailDeskripsi.text = description
        Glide.with(this)
            .load(images)
            .into(binding.imageDetail)


    }


    override fun  onSupportNavigateUp()
    : Boolean {
        onBackPressed()
        return true
    }


    override fun onBackPressed(){
        super.onBackPressed()
    }
}

