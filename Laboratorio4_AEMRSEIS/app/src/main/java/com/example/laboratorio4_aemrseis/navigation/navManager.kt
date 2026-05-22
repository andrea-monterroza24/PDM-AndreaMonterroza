package com.example.laboratorio4_aemrseis.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4_aemrseis.view.Greeting
import com.example.laboratorio4_aemrseis.view.HomeScreen
import com.example.laboratorio4_aemrseis.viewModel.GeneralViewModel


@Composable
fun NavManager() {

    val navController = rememberNavController()

    val viewModel: GeneralViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {

            HomeScreen(navController)
        }

        composable("tasks") {

            Greeting(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}