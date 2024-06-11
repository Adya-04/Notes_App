package com.example.mynotes

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<note>> = noteDao.getAllNotes()

    //The suspend modifier tells the compiler that this needs to be called from a coroutine or another suspending function.

    suspend fun insert(note: note){
        noteDao.insert(note)
    }
    //Suspend is a coroutine function
    suspend fun delete(note: note){
        noteDao.delete(note)
    }

}