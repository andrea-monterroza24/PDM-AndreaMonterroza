package com.example.laboratorio6_aemrseis.data.remote

import com.example.laboratorio6_aemrseis.data.model.MealResponse
import retrofit2.http.GET

interface ApiService {

    @GET("search.php?s=")
    suspend fun getMeals(): MealResponse

}