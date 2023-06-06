package com.example.mybooks

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menu_about -> {
                val moveAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveAbout)

                true

            }


            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }


    private fun getListBooks(): ArrayList<Books> {
        val dataImages = resources.getStringArray(R.array.data_images)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataLink = resources.getStringArray(R.array.data_link)
        val listBooks = ArrayList<Books>()

        for (i in dataName.indices) {
            val books = Books(dataName[i], dataDescription[i], dataImages[i],dataLink[i])
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