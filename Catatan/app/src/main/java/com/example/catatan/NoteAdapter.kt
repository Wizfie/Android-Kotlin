package com.example.catatan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catatan.room.Note

class NoteAdapter (private val notes : ArrayList<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        TODO("Not yet implemented")
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_note,parent,false)
        )
    }
    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        TODO("Not yet implemented")
        val note = notes[position]
    }
        class NoteViewHolder(  view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Note>){
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

}


