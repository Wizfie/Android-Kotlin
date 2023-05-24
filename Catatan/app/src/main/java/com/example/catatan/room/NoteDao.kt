package com.example.catatan.room

import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note : Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note :Note)

    @Query("SELECT * From note")
    suspend fun getNotes():List<Note>

}