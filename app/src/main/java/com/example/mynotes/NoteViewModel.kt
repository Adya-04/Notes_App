package com.example.mynotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : NoteRepository
    //Activity can observe all the changes which are made bcz we have initialized it as main data
    val allNotes: LiveData<List<note>>

    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNotes= repository.allNotes
    }

    fun deleteNote(note: note)= viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
//Dispatchers.IO -> This tells the coroutine to run the block of code within the launch function on a background thread that is optimized for IO operations.
    fun insertNote(note: note)= viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }


}