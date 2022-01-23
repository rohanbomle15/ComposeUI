package com.composeui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.composeui.model.Person
import com.composeui.model.person1
import com.composeui.ui.theme.behaviourBackground
import com.composeui.ui.theme.behaviourTextColor
import com.composeui.viewmodel.PersonDetailsViewModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PersonDetailsScreen(navController: NavController, petId: String, viewModel: PersonDetailsViewModel) {
    LaunchedEffect(petId) {
        viewModel.loadPetInfo(petId = petId)
    }
    Surface(color = MaterialTheme.colors.background) {
        val petState = viewModel.personData.observeAsState()
        if (petState.value != null) {
            val pet = petState.value!!
            PersonDetails(person = pet, onBackPress = { navController.popBackStack() })
        }
    }
}

@Preview
@Composable
fun PreviewPersonDetails() {
    PersonDetails(person = person1, onBackPress = {})
}

@Composable
fun PersonDetails(person: Person, onBackPress: () -> Unit) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        CoilImage(
            data = person.imageUrl,
            contentDescription = null,
            fadeIn = true,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(350.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = CornerSize(0.dp),
                        topEnd = CornerSize(0.dp),
                        bottomEnd = CornerSize(32.dp),
                        bottomStart = CornerSize(32.dp)
                    )
                )
        )
        PersonCardInformation(person = person)
        NameDetailSection(person = person)
        Location(person = person)
        AboutSection(person = person)
    }
    Icon(
        Icons.Filled.ArrowBack, "back",
        modifier = Modifier
            .size(48.dp)
            .clickable {
                onBackPress()
            }
            .padding(12.dp)
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        AdoptButtonBar()
    }
}

@Composable
fun NameDetailSection(person: Person) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = person.name,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp)
        )
        Text(
            text = person.ethnicity,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp),
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun AboutSection(person: Person) {
    Text(
        text = stringResource(id = R.string.about_text),
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    )
    Text(
        text = person.description,
        textAlign = TextAlign.Justify,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(16.dp)
    )
    Spacer(modifier = Modifier.height(64.dp))
}

@Composable
fun Location(person: Person) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Outlined.Place, null,
            modifier = Modifier
                .width(16.dp)
                .padding(end = 2.dp, top = 2.dp)
        )
        Text(
            text = person.location,
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
fun PersonCardInformation(person: Person) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        InfoCard(
            title = R.drawable.ic_hourglass,
            text = person.age.toString() + " Years"
        )
        InfoCard(
            title = R.drawable.ic_weight,
            text = "${person.weightKg}kg"
        )
        InfoCard(
            title = R.drawable.ic_sex,
            text = person.gender.name
        )
        InfoCard(
            title = R.drawable.ic_health,
            text = person.health
        )
    }
}

@Composable
fun InfoCard(title: Int, text: String) {
    Card(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
            .size(80.dp, 64.dp)
            .clip(RoundedCornerShape(12.dp)),
        elevation = 8.dp,
        backgroundColor = behaviourBackground
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = title), null,
                modifier = Modifier
                    .width(24.dp)
                    .padding(end = 2.dp, top = 2.dp),

                )
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun AdoptButtonBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Button(
            elevation = null,
            modifier = Modifier
                .padding(16.dp)
                .weight(4f)
                .height(52.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(behaviourBackground)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_like),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(16.dp)
                        .padding(top = 2.dp, end = 2.dp)
                )
                Text(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = behaviourTextColor,
                    text = stringResource(id = R.string.like_button)
                )
            }
        }
        Button(
            elevation = null,
            colors = ButtonDefaults.buttonColors(backgroundColor = behaviourBackground),
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
                .weight(1f)
                .wrapContentWidth()
                .height(52.dp),
            onClick = {}
        ) {
            Icon(
                Icons.Filled.Phone, "phone",
                tint = behaviourTextColor,
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp)
            )
        }
    }
}