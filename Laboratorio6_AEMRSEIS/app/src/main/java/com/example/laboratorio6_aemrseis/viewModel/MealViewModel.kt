package com.example.laboratorio6_aemrseis.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio6_aemrseis.data.model.Meal
import com.example.laboratorio6_aemrseis.data.remote.RetrofitInstance
import kotlinx.coroutines.launch
import java.io.IOException

class MealViewModel : ViewModel() {

    var meals by mutableStateOf<List<Meal>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun loadMeals() {

        viewModelScope.launch {

            isLoading = true

            try {

                meals = RetrofitInstance
                    .api
                    .getMeals()
                    .meals

            } catch (e: IOException) {

                errorMessage = "Sin conexión a Internet"

            } catch (e: Exception) {

                errorMessage = "Error inesperado"

            } finally {

                isLoading = false
            }
        }
    }
}