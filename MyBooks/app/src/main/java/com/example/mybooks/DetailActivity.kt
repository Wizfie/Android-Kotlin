package com.example.mybooks

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mybooks.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Detail Book"


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra("key_name")
        val description = intent.getStringExtra("key_description")
        val images = intent.getStringExtra("key_images")



        binding.detailNamaBuku.text = name
        binding.detailDeskripsi.text = description
        Glide.with(this).load(images).into(binding.imageDetail)


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.share_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val pembelian = intent.getStringExtra("key_link")

        return when (item.itemId) {


            R.id.menu_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(
                    Intent.EXTRA_TEXT, "$pembelian"
                ) // Ganti dengan konten yang ingin Anda bagikan

                if (shareIntent.resolveActivity(packageManager) != null) {
                    startActivity(
                        Intent.createChooser(
                            shareIntent, "Bagikan melalui"
                        )
                    )
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}





