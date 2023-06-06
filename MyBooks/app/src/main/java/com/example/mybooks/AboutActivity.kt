package com.example.mybooks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mybooks.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "About Me"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        redirectEmail()

        val requestOptions = RequestOptions.circleCropTransform()

        Glide.with(this)
            .load(R.drawable.gambar)
            .apply(requestOptions)
            .into(binding.ImageProfile)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun redirectEmail() {
        binding.txEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:wizfiee@gmail.com") // email penerima yang sesuai

            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            }


        }
    }
}



