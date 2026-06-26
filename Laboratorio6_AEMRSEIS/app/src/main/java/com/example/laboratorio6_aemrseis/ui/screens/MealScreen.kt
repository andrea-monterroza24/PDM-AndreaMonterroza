package com.example.laboratorio6_aemrseis.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.laboratorio6_aemrseis.viewModel.MealViewModel

@Composable
fun MealScreen(
    viewModel: MealViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.loadMeals()
    }

    when {

        viewModel.isLoading -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        viewModel.errorMessage.isNotEmpty() -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(viewModel.errorMessage)
            }
        }

        else -> {

            LazyColumn {

                items(viewModel.meals) { meal ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            AsyncImage(
                                model = meal.strMealThumb,
                                contentDescription = meal.strMeal,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = meal.strMeal,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = "Categoría: ${meal.strCategory}"
                            )

                            Text(
                                text = "Origen: ${meal.strArea}"
                            )
                        }
                    }
                }
            }
        }
    }
}