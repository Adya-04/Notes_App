package com.example.mynotes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //The OnConflictStrategy.IGNORE strategy means that if there's a conflict (like a duplicate primary key), Room will ignore the new data and not insert it, leaving the existing data unchanged.
    suspend fun insert(note: note)
    //suspend tells us that it can be called by bg thread only
    @Delete
    suspend  fun delete(note: note)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<note>>
}