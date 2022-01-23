package com.composeui.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.composeui.model.Person

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PersonLazyColumn(modifier: Modifier, people: List<Person>, onPetClick: (Person) -> Unit) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        modifier = modifier, scrollState,
        content = {

            items(people.size) { index ->
                PersonCardListItem(person = people[index], onPetClick = onPetClick)
            }
        },
    )
}