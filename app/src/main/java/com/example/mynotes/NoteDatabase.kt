package com.example.mynotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(note::class), version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    //To make this singleton(to avoid multiple instances of NoteDatabase class):
    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            //The synchronized block is used in this code to ensure that only one thread can execute the block at a time. This is important to prevent multiple threads from creating multiple instances of the NoteDatabase class.
            //Thread Safety: In a multi-threaded environment, multiple threads might try to initialize the INSTANCE variable simultaneously. Without synchronization, this could result in creating multiple instances of the NoteDatabase class, which would defeat the purpose of the Singleton pattern.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}