package com.sjdroid.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sjdroid.noteapp.ui.theme.BabyBlue
import com.sjdroid.noteapp.ui.theme.LightGreen
import com.sjdroid.noteapp.ui.theme.RedOrange
import com.sjdroid.noteapp.ui.theme.RedPink
import com.sjdroid.noteapp.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null,
) {
    companion object {
        val noteColors = listOf(RedOrange, BabyBlue, Violet, RedPink, LightGreen)
    }
}

class InvalidNoteException(message: String) : Exception(message)
