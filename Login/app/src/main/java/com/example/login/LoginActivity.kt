package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

 private lateinit var btnback : ImageView
 private lateinit var toRegis : TextView

 fun init(){
     btnback = findViewById(R.id.login_back)
     toRegis = findViewById(R.id.toRegister)
 }
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

            init()
            backbutton()
            toRegister()
    }

    private fun backbutton(){
        btnback.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun toRegister(){
        toRegis.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}