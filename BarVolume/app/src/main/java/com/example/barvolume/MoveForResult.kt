package com.example.barvolume

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.barvolume.databinding.ActivityMoveForResultBinding


class MoveForResult : AppCompatActivity() {

    private lateinit var binding: ActivityMoveForResultBinding

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPilih.setOnClickListener { btnPilih() }


    }

    fun btnPilih() {
        val numberInput = binding.rgNumber
        val radio1: RadioButton = binding.rb50
        val radio2: RadioButton = binding.rb100
        val radio3: RadioButton = binding.rb150
        val radio4: RadioButton = binding.rb200
        var value: Int? = null
        if (numberInput.checkedRadioButtonId > 0) {


            if (numberInput.checkedRadioButtonId > 0) {
                value = when (numberInput.checkedRadioButtonId) {
                    radio1.id -> 50
                    radio2.id -> 100
                    radio3.id -> 150
                    radio4.id -> 200
                    else -> null
                }

            }

            if ( value != null){
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}