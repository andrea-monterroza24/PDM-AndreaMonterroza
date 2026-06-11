package com.example.laboratorio5_aemrseis.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio5_aemrseis.model.AppDatabase
import com.example.laboratorio5_aemrseis.view.Greeting
import com.example.laboratorio5_aemrseis.view.HomeScreen
import com.example.laboratorio5_aemrseis.viewModel.GeneralViewModel


@Composable
fun NavManager() {

    val context = LocalContext.current
    val dao = AppDatabase.getDatabase(context).taskDao()

    val viewModel = remember {
        GeneralViewModel(dao)
    }

    val navController = rememberNavController()


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