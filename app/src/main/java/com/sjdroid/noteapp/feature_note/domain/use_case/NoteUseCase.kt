package com.sjdroid.noteapp.feature_note.domain.use_case

data class NoteUseCase(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val getNoteByIdUseCase: GetNoteByIdUseCase,
)
