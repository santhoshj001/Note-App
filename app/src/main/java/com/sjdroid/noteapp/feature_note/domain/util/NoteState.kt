package com.sjdroid.noteapp.feature_note.domain.util

import com.sjdroid.noteapp.feature_note.domain.model.Note

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false,
)
