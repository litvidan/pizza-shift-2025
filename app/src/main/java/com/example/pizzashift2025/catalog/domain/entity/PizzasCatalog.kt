package com.example.pizzashift2025.catalog.domain.entity

data class PizzasCatalog (
    val success: Boolean,
    val reason: String,
    val catalog: List<Pizza>
)