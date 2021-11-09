package com.sjdroid.noteapp.feature_note.data.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sjdroid.noteapp.feature_note.data.data_source.dao.NoteDao
import com.sjdroid.noteapp.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}
