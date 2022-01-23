package com.composeui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.composeui.ui.theme.ComposeAdoptionAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAdoptionAppTheme {
                ComposeAdoptionApp()
            }
        }
    }
}

@Composable
fun ComposeAdoptionApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "list") {
        composable("list") { PersonMainScreen(navController, viewModel = viewModel()) }
        composable(
            "details/{petId}",
            arguments = listOf(navArgument("petId") { type = NavType.StringType })
        ) {
            PersonDetailsScreen(
                navController,
                petId = it.arguments?.getString("petId")!!,
                viewModel = viewModel()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAdoptionAppTheme {
        ComposeAdoptionApp()
    }
}
