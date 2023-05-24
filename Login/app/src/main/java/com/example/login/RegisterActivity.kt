package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var toLogin: TextView

    fun init() {
        btnBack = findViewById(R.id.register_back)
        toLogin = findViewById(R.id.toLogin)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
        BackButton()
        toLoginPage()
    }


   private fun BackButton(){
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun toLoginPage(){
        toLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}