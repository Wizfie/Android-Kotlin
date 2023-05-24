package com.example.newcrud

import android.content.ContentValues
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.newcrud.R.id.actionDelete

class BarangActivity : AppCompatActivity() {

    lateinit var editTextNama: EditText
    lateinit var editTextJenis: EditText
    lateinit var editTextHarga: EditText


    private fun init() {
        editTextNama = findViewById(R.id.editTextNama)
        editTextJenis = findViewById(R.id.editTextJenis)
        editTextHarga = findViewById(R.id.editTextHarga)

    }

    var id = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)


        try {
            var bundle: Bundle = intent.extras!!
            id = bundle.getInt("mainActId", 0)
            if (id != 0) {

                editTextNama.setText(bundle.getString("MainActNama"))
                editTextJenis.setText(bundle.getString("MainActJenis"))
                editTextHarga.setText(bundle.getString("MainActBarang"))
            }
        } catch (ex: Exception) {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.add_main, menu)

        val itemDelete: MenuItem = menu.findItem(actionDelete)
        if (id == 0) {
            itemDelete.isVisible = false
        } else {
            itemDelete.isVisible = true
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.actionSave -> {
                var dbAdapter = DBAdapter(this)

                var values = ContentValues()
                values.put("Nama", editTextNama.text.toString())
                values.put("Jenis", editTextJenis.text.toString())
                values.put("Harga", editTextHarga.text.toString())

                if (id == 0){
                    val mID = dbAdapter.insert(values)

                    if (mID > 0){
                        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    var selectionArgs = arrayOf(id.toString())
                    val mID = dbAdapter.update(values, "Id=?", selectionArgs)
                    if (mID > 0){
                        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            R.id.actionDelete ->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Delete Data")
                builder.setMessage("This Data Will Be Deleted")

                builder.setPositiveButton("Delete") {dialog: DialogInterface?, which: Int ->
                    var dbAdapter = DBAdapter(this)
                    val selectionArgs = arrayOf(id.toString())
                    dbAdapter.delete("Id=?", selectionArgs)
                    Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                    finish()
                }
                builder.setNegativeButton("Cancel"){dialog: DialogInterface?, which: Int ->  }

                val alertDialog: AlertDialog = builder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        return when (item.itemId) {
//            R.id.actionSave -> {
//                var dbAdapter = DBAdapter(this)
//                var values = ContentValues()
//                values.put("Name", editTextNama.text.toString())
//                values.put("Jenis", editTextJenis.text.toString())
//                values.put("Harga", editTextHarga.text.toString())
//
//                if (id == 0) {
//                    val mID = dbAdapter.insert(values)
//
//                    if (mID > 0) {
//                        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
//                        finish()
//                    } else {
//                        Toast.makeText(this, "Failed to Save data", Toast.LENGTH_SHORT).show()
//                    }
//                } else {
//                    var selectionArgs = arrayOf(id.toString())
//                    var mID = dbAdapter.update(values, "Id=?", selectionArgs)
//                    if (mID > 0) {
//                        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
//                        finish()
//                    } else {
//                        Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show()
//                    }
//                    true
//                }
//                actionDelete {
//                    val builder = AlertDialog.Builder(this)
//                    builder.setTitle("Delete Data?")
//                    builder.setMessage("This data will be deleted")
//
//                    builder.setPositiveButton("Delete") { dialog: DialogInterface?, which: Int ->
//                        var dbAdapter = DBAdapter(this)
//                        var selectionArgs = arrayOf(id.toString())
//                        Toast.makeText(this, "Text Deleted", Toast.LENGTH_SHORT).show()
//                        finish()
//                    }
//                    builder.setNegativeButton("Cancel") { dialog: DialogInterface?, which: Int -> }
//                    val alertDialog: AlertDialog = builder.create()
//                    alertDialog.setCancelable(false)
//                    alertDialog.show()
//                }
//                return true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//}