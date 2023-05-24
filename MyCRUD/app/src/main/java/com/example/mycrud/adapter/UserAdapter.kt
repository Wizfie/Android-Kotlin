package com.example.mycrud.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycrud.R
import com.example.mycrud.data.entity.User

@Suppress("UNREACHABLE_CODE")
class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
   class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
       var fullname: TextView
       var email: TextView
       var phone: TextView

       init {

           fullname = view.findViewById(R.id.viewFullname)
           email = view.findViewById(R.id.viewEmail)
           phone = view.findViewById(R.id.viewPhone)

       }

   }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_user ,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.fullname.text = list[position].firstName
        holder.email.text = list[position].email
        holder.phone.text = list[position].phone



    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return list.size
    }
}

