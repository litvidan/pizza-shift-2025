package com.example.pizzashift2025.catalog.data.network

import com.example.pizzashift2025.catalog.data.model.PizzasCatalogModel
import retrofit2.http.GET

interface PizzasCatalogApi {
    @GET("pizza/catalog")
    suspend fun getAll(): PizzasCatalogModel
}