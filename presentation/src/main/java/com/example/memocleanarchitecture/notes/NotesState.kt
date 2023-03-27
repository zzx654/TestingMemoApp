package com.example.memocleanarchitecture.notes

import com.example.domain.model.Note
import com.example.domain.util.NoteOrder
import com.example.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
