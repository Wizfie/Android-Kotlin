package com.example.catatan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.catatan.room.Note
import com.example.catatan.room.NoteDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {


    private lateinit var saveButton: Button
    private lateinit var editTitle: EditText
    private lateinit var editNote: EditText
//    private lateinit var text_title : TextView

    val db by lazy { NoteDB(this) }


    fun init(){
        saveButton = findViewById(R.id.saveButton)
        editNote = findViewById(R.id.editNote)
        editTitle = findViewById(R.id.editTitle)
//        text_title = findViewById(R.id.text_title)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        init()
        setupListener()
    }

    fun setupListener(){
        saveButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.noteDao().addNote(
                    Note (0,editTitle.text.toString(),editTitle.text.toString())
                )
                finish()
            }
        }
    }
}