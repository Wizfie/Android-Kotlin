package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btn_login : Button
    private lateinit var btn_register : Button

   fun init(){
        btn_login = findViewById(R.id.buttonLandingLogin)
        btn_register = findViewById(R.id.buttonLandingRegister)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        LoginLanding()
        RegisLanding()
    }

    private fun LoginLanding(){
        btn_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
    private fun RegisLanding(){
        btn_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

}