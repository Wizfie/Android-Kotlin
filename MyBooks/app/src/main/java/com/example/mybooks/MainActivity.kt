package com.example.mybooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybooks.databinding.ActivityMainBinding
import com.example.myrecyclerview.ListBooksAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Books>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.rvBooks.setHasFixedSize(true)
        setContentView(binding.root)
        list.addAll(getListBooks())
        showRecyclerList()



    }


    private fun getListBooks() : ArrayList<Books> {
        val dataImages = resources.getStringArray(R.array.data_images)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataName = resources.getStringArray(R.array.data_name)
        val listBooks = ArrayList<Books>()
        for (i in dataName.indices){
            val books = Books(dataName[i], dataDescription[i],dataImages[i])
            listBooks.add(books)
        }
        return listBooks
    }

    private fun showRecyclerList() {
        binding.rvBooks.layoutManager = LinearLayoutManager(this)

        val listBooksAdapter = ListBooksAdapter(list)
        binding.rvBooks.adapter = listBooksAdapter
    }
}