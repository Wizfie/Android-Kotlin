package com.example.barvolume


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.barvolume.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResult.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0)
            binding.tvResult.text = "Hasil : $selectedValue"  // Menggunakan View Binding
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener { calculate() }
        binding.toPage2.setOnClickListener { page2() }
        binding.toPage3Data.setOnClickListener { page3() }
        binding.toPage4WithObject.setOnClickListener { page4()}
        binding.dialNumber.setOnClickListener { dialBtn() }
        binding.btnMoveForResult.setOnClickListener { moveResult() }
    }

    private  fun moveResult(){
        val moveForResultIntent = Intent(this@MainActivity, MoveForResult::class.java)
        resultLauncher.launch(moveForResultIntent)
    }

    private  fun dialBtn(){

        val phoneNumber = "081210841382"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
    }

    private fun page4(){

        val person = Person(
            "Wisfie",
            24,
            "Wisfie@gmail.com",
            "Tangerang"
        )

        val moveWithObjectIntent = Intent(this@MainActivity, PageFour::class.java)
        moveWithObjectIntent.putExtra(PageFour.EXTRA_PERSON,person)
        startActivity(moveWithObjectIntent)

    }

    private fun page3(){
        val moveDataIntent = Intent(this@MainActivity, PageThree::class.java)
        moveDataIntent.putExtra(PageThree.EXTRA_NAME,"Wisfie")
        moveDataIntent.putExtra(PageThree.EXTRA_AGE,24)
        startActivity(moveDataIntent)
    }

    private fun page2(){
        startActivity(Intent(this@MainActivity,PageTwo::class.java))
    }

    private fun calculate(){
        val lebar = binding.EdLebar.text.toString()
        val panjang = binding.EdPanjang.text.toString()
        val tinggi = binding.EdTinggi.text.toString()
        val result = binding.result


        if (lebar.isEmpty() || panjang.isEmpty() || tinggi.isEmpty()){

            if (lebar.isEmpty()) binding.EdLebar.error = "Input lebar tidak boleh kosong"
            if (panjang.isEmpty()) binding.EdPanjang.error = "Input panjang tidak boleh kosong"
            if (tinggi.isEmpty()) binding.EdTinggi.error = "Input tinggi tidak boleh kosong"
            Toast.makeText(applicationContext ,"Harap isi Semua kolom",Toast.LENGTH_SHORT).show()
            return

        } else {
            val valueLebar = lebar.toDouble()
            val valuePanjang = panjang.toDouble()
            val valueTinggi = tinggi.toDouble()
            val volume = valueLebar * valuePanjang * valueTinggi
            result.text = volume.toString()
        }
    }

}




