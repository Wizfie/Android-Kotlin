package com.example.tiptime

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    override fun onConfigurationChanged(newConfig: Configuration) {

     
        super.onConfigurationChanged(newConfig)
        // Cek apakah mode gelap diaktifkan
        if ((newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
            // Mode gelap diaktifkan
            setTheme(R.style.Theme_TipTime_dark)
        } else {
            // Mode gelap dinonaktifkan
            setTheme(R.style.Theme_TipTime)
        }

        // Panggil kembali recreate() agar tema diterapkan
        recreate()
    }


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener { calculateTip()}
        binding.txInput.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode) }

    }
    private fun calculateTip(){
        val stringTextfield = binding.txInput.text.toString()
        val cost = if(stringTextfield.isNotEmpty()) {
            stringTextfield.toDouble()
        } else {0.0}

        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId){
            R.id.btn_amazing -> 0.20
            R.id.btn_good -> 0.15
            else -> 0.10
        }

        var tip = cost * tipPercentage
        if (binding.btnSwitchRound.isChecked){
            tip = kotlin.math.ceil(tip)

            displayTip(tip)
            }
        }

    private fun displayTip(tip:Double){
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount , formattedTip)
        }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
        }
    }



