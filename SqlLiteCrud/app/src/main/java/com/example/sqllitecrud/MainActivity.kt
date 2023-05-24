package com.example.sqllitecrud

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    private lateinit var EditName: EditText
    private lateinit var EditEmail: EditText
    private lateinit var addButton: Button
    private lateinit var viewButton: Button
    private lateinit var updateButton: Button
//    private lateinit var buttonDelete: Button
    private lateinit var sqliteHelper:SQLiteHelper
    private lateinit var recyclerView: RecyclerView
    private var adapter: StudentAdapter? = null
    private var std : StudentModel? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initRecyclerView()

        sqliteHelper = SQLiteHelper(this)

        addButton.setOnClickListener { addStudent() }
        viewButton.setOnClickListener { getStudents() }
        updateButton.setOnClickListener { updateStudent() }

            adapter?.setOnclickItem { Toast.makeText(this,it.name, Toast.LENGTH_SHORT).show()

//            Update Record
            EditName.setText(it.name)
            EditEmail.setText(it.email)
            std = it

        }
            adapter?.setOnclickDeleteItem {
                it.id?.let { it1 -> deleteStudent(it1) }
            }
    }


    private  fun getStudents(){
        val stdlist = sqliteHelper.getAllStudent()
        Log.i("List Student" , "${stdlist.size}")

//        Display Data RecyclerView
        adapter?.addItem(stdlist)
    }



    private fun addStudent(){
        val name = EditName.text.toString()
        val email = EditEmail.text.toString()
//        val id = null


        if (name.isEmpty() || email.isEmpty()){
            Toast.makeText(this , "Please enter required field", Toast.LENGTH_SHORT ).show()
        }else {
            val std = StudentModel(id = null, name =name , email = email)
            val status = sqliteHelper.insertStudent(std)

            if (status > -1) {
                Toast.makeText(this,"Success , Data Saved", Toast.LENGTH_SHORT).show()
                clearEditText()
                getStudents()
            }else{
                Toast.makeText(this, "Failed to Save Data" , Toast.LENGTH_SHORT).show()

            }

        }
    }

    private  fun updateStudent() {

        val name = EditName.text.toString()
        val email = EditEmail.text.toString()

//        Cek Record not change
        if (name == std?.name && email == std?.email){
            Toast.makeText(this,"Record not change",Toast.LENGTH_SHORT).show()
            return
        }
        if (std == null) return

        val std = StudentModel(id = std!!.id, name = name , email = email)
        val status = sqliteHelper.updateStudent(std)
        if (status > -1) {
            clearEditText()
            getStudents()
        } else {
            Toast.makeText(this,"Update Failed",Toast.LENGTH_SHORT).show()

        }


    }

    private fun deleteStudent(id:Int){
        if (id == null ) return

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Delete?")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes"){ dialog, _->
            sqliteHelper.deleteStudentById(id)
            getStudents()
            dialog.dismiss()

        }
        builder.setNegativeButton("No") {
            dialog, _->
            dialog.dismiss()
        }

        val alert = builder.create()
        alert.show()
    }

    private fun clearEditText(){
        EditName.setText("")
        EditEmail.setText("")
        EditName.requestFocus()
    }


    private  fun initRecyclerView(){
        recyclerView.layoutManager  = LinearLayoutManager(this)
        adapter = StudentAdapter()
        recyclerView.adapter = adapter
    }

    private fun initComponents(){

        EditName = findViewById(R.id.EditName)
        EditEmail = findViewById(R.id.EditEmail)
        addButton = findViewById(R.id.addButton)
        viewButton = findViewById(R.id.viewButton)
        updateButton = findViewById(R.id.updateButton)
        recyclerView = findViewById(R.id.recycleView)
//        buttonDelete = findViewById(R.id.buttonDelete)

    }
}