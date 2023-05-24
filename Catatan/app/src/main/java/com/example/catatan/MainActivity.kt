package com.example.catatan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catatan.room.NoteDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var createButton : Button
    private lateinit var listNote: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
//    lateinit var text_title : TextView

    private val db by lazy { NoteDB(this) }


    private fun init() {
        createButton = findViewById(R.id.createButton)
//        text_title = findViewById(R.id.text_title)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setupListener()
        setupRecyclerview()
    }

    override fun onStart() {
        super.onStart()
            CoroutineScope(Dispatchers.IO).launch {
                 val notes = db.noteDao().getNotes()
    //                Log.d("MainActivity","dbResponse: $notes")
                withContext(Dispatchers.Main){
                    noteAdapter.setData(notes)
                }


        }
    }

    private fun setupListener(){
        createButton.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    private fun setupRecyclerview(){
        noteAdapter = NoteAdapter(arrayListOf())
        listNote.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = noteAdapter

        }
    }
}