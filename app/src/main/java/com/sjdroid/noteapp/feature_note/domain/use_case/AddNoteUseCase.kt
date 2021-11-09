package com.sjdroid.noteapp.feature_note.domain.use_case

import com.sjdroid.noteapp.feature_note.domain.model.InvalidNoteException
import com.sjdroid.noteapp.feature_note.domain.model.Note
import com.sjdroid.noteapp.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("the title of a note can't be empty ")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("the content of a note can't be empty ")
        }
        noteRepository.insertNote(note)
    }
}
