package com.example.cctv

import android.os.Bundle
import android.webkit.WebView
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cctv1= "http://192.168.0.200:81/stream"
        val cctv2= "http://192.168.0.201:81/stream"

        val webView = WebView(this)
        true.also { webView.settings.javaScriptEnabled = it }
        webView.loadUrl("$cctv1")
//        webView.loadUrl("https://www.google.co.id/")

        val frameLayout = findViewById<FrameLayout>(R.id.frame_layout)
        frameLayout.addView(webView)



        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            val b = when (item.itemId) {
                R.id.menu_home -> {
                    webView.loadUrl("$cctv1")
                    true
                }
                R.id.menu_about -> {
                    webView.loadUrl("$cctv2")
                    true
                }
                else -> {
                    false
                }
            }
            b
        }
    }
}

