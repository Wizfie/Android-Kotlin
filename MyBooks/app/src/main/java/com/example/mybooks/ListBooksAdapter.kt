package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybooks.Books
import com.example.mybooks.R

class ListBooksAdapter(private  val listBooks:ArrayList<Books>) :RecyclerView.Adapter<ListBooksAdapter.ListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_books, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listBooks.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, images) = listBooks[position]
        Glide.with(holder.itemView.context)
            .load(images)
            .into(holder.imgBooks)

        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Kamu Memilih " + listBooks[holder.adapterPosition].name, Toast.LENGTH_SHORT
            ).show()
        }
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBooks: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

    }
}





