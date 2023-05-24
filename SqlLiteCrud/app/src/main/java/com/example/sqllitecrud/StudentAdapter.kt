package com.example.sqllitecrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var stdlist : ArrayList<StudentModel> = ArrayList()
    private var onClickItem : ((StudentModel)-> Unit)? = null
    private var onClickDeleteItem : ((StudentModel)-> Unit)? = null

    fun addItem(items : ArrayList<StudentModel>) {
        this.stdlist = items
        notifyDataSetChanged()

    }

    fun setOnclickItem(callback : (StudentModel) -> Unit) {
        this.onClickItem = callback
    }

    fun setOnclickDeleteItem(callback: (StudentModel) -> Unit) {
            this.onClickDeleteItem = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StudentViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.cards_item_std, parent ,false)

            )


    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val std = this.stdlist[position]
        holder.bindView(std)
        holder.itemView.setOnClickListener { onClickItem?.invoke(std)  }
        holder.buttonDelete.setOnClickListener { onClickDeleteItem?.invoke(std)  }
    }
    override fun getItemCount(): Int {
        return this.stdlist.size

    }


    class StudentViewHolder( var view :View): RecyclerView.ViewHolder(view) {

        private var id = view.findViewById<TextView>(R.id.viewId)
        private var name = view.findViewById<TextView>(R.id.viewName)
        private var email = view.findViewById<TextView>(R.id.viewEmail)
         var buttonDelete = view.findViewById<TextView>(R.id.buttonDelete)

        fun bindView(std : StudentModel) {
            id.text =   std.id.toString()
            name.text = std.name
            email.text = std.email
        }
    }
}