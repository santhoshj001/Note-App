package com.sjdroid.noteapp.feature_note.domain.use_case

import com.sjdroid.noteapp.feature_note.domain.model.Note
import com.sjdroid.noteapp.feature_note.domain.repository.NoteRepository

class GetNoteByIdUseCase(
    val noteRepository: NoteRepository,
) {
    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteById(id)
    }
}
