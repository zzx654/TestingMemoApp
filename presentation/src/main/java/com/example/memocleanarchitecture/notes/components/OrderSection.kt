package com.example.memocleanarchitecture.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.util.NoteOrder
import com.example.domain.util.OrderType
import com.example.memocleanarchitecture.notes.components.DefaultRadioButton

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
   Column(
       modifier = modifier
   ) {
       Row(
           modifier = Modifier.fillMaxWidth()
       ) {
           DefaultRadioButton(
               text = "Title",
               selected = noteOrder is NoteOrder.Title,
               onSelect = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
           )
           Spacer(modifier = Modifier.width(8.dp))
           DefaultRadioButton(
               text = "Date",
               selected = noteOrder is NoteOrder.Date,
               onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
           )
           Spacer(modifier = Modifier.width(8.dp))
           DefaultRadioButton(
               text = "Color",
               selected = noteOrder is NoteOrder.Color,
               onSelect = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
           )
       }
       Spacer(modifier = Modifier.height(16.dp))
       Row(
           modifier = Modifier.fillMaxWidth()
       ) {
           DefaultRadioButton(
               text = "Ascending",
               selected = noteOrder.orderType is OrderType.Ascending,
               onSelect = {
                   onOrderChange(noteOrder.copy(OrderType.Ascending))
               }
           )
           Spacer(modifier = Modifier.width(8.dp))
           DefaultRadioButton(
               text = "Descending",
               selected = noteOrder.orderType is OrderType.Descending,
               onSelect = {
                   onOrderChange(noteOrder.copy(OrderType.Descending))//ordertype(오름차순,내림차순이 안정해져있기때문에 결정)
               }
           )
       }
   }
}