package com.sjdroid.noteapp.feature_note.di

import android.app.Application
import androidx.room.Room
import com.sjdroid.noteapp.feature_note.data.data_source.database.NoteDatabase
import com.sjdroid.noteapp.feature_note.data.repository.NoteRepositoryImpl
import com.sjdroid.noteapp.feature_note.domain.repository.NoteRepository
import com.sjdroid.noteapp.feature_note.domain.use_case.AddNoteUseCase
import com.sjdroid.noteapp.feature_note.domain.use_case.DeleteNoteUseCase
import com.sjdroid.noteapp.feature_note.domain.use_case.GetNoteByIdUseCase
import com.sjdroid.noteapp.feature_note.domain.use_case.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.sjdroid.noteapp.feature_note.domain.use_case.NoteUseCase as NoteUseCase1

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDataBase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUSeCases(noteRepository: NoteRepository): NoteUseCase1 {
        return NoteUseCase1(
            getNotesUseCase = GetNotesUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository),
            addNoteUseCase = AddNoteUseCase(noteRepository),
            getNoteByIdUseCase = GetNoteByIdUseCase(noteRepository)
        )
    }
}
