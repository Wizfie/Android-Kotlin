package com.example.mycrud

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycrud.adapter.UserAdapter
import com.example.mycrud.data.AppDatabase
import com.example.mycrud.data.entity.User
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingButton: FloatingActionButton
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase
    private var list = mutableListOf<User>()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycleView)
        floatingButton = findViewById(R.id.floatingButton)
        floatingButton = findViewById(R.id.floatingButton)
        adapter = UserAdapter(list)
        database = AppDatabase.getInstance(applicationContext)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL,false)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, VERTICAL))

        floatingButton.setOnClickListener {
            startActivity(Intent(this,EditorActivity::class.java))
        }
    }
    override fun onResume(){
        super.onResume()
        getData()
    }


    @SuppressLint("NotifyDataSetChanged")
    fun getData(){
        list.clear()
        list.addAll(database.userDao().getAll())
        adapter.notifyDataSetChanged()
    }

}

