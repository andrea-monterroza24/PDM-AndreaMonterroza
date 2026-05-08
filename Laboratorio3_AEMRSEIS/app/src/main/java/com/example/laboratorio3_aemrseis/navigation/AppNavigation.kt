package com.example.laboratorio3_aemrseis.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio3_aemrseis.screens.HomeScreen
import com.example.laboratorio3_aemrseis.screens.ListaNombresApp
import com.example.laboratorio3_aemrseis.screens.SensorScreen
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("names") {
            ListaNombresApp(navController)
        }

        composable("sensor") {
            SensorScreen(navController)
        }
    }
}