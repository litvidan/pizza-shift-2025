package com.example.pizzashift2025.catalog.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PizzasCatalogModel (
    val success: Boolean,
    val reason: String,
    val catalog: List<PizzaModel>
)