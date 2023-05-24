package com.example.mycrud

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycrud.data.AppDatabase
import com.example.mycrud.data.entity.User

class EditorActivity : AppCompatActivity() {
    private lateinit var fullname: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var addButton: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        fullname = findViewById(R.id.editFullname)
        email = findViewById(R.id.editEmail)
        phone = findViewById(R.id.editPhone)
        addButton = findViewById(R.id.editAddButton)
        database =AppDatabase.getInstance(applicationContext)

        addButton.setOnClickListener {
            if( fullname.text.isNotEmpty() &&
                email.text.isNotEmpty() &&
                phone.text.isNotEmpty())
            {
                database.userDao().insertAll(
                    User(
                    null,
                    fullname.text.toString(),
                    email.text.toString(),
                    phone.text.toString(),
                    ))

            } else { Toast.makeText(applicationContext,"Harap isi semua data", Toast.LENGTH_SHORT).show()

            }
        }



    }
}