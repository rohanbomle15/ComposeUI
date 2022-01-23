package com.composeui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.composeui.model.Person
import com.composeui.model.person1
import com.composeui.model.person3
import com.composeui.model.person4
import com.composeui.ui.theme.background
import com.composeui.viewmodel.PersonMainScreenViewModel
import com.composeui.widgets.PersonLazyColumn

@Composable
fun PersonMainScreen(navController: NavController, viewModel: PersonMainScreenViewModel) {
    val pets = viewModel.petsData.observeAsState(emptyList())
    PersonListScreenContent(people = pets.value) { pet ->
        val petId = pet.id
        navController.navigate(route = "details/$petId")
    }
}

@Preview
@Composable
fun PersonListPreview() {
    PersonListScreenContent(people = listOf(person1, person3, person4), onPetSelected = {})
}

@Composable
fun PersonListScreenContent(people: List<Person>, onPetSelected: (Person) -> Unit) {
    Surface(color = background, elevation = 4.dp) {
        Column {
            Row(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(
                            start = 24.dp,
                            end = 24.dp,
                            top = 24.dp,
                            bottom = 8.dp
                        )
                )
            }

            PersonLazyColumn(
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp
                ),
                people
            ) { pet ->
                onPetSelected(pet)
            }
        }
    }
}