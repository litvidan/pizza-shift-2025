package com.example.pizzashift2025.details

import com.example.pizzashift2025.catalog.domain.entity.Pizza
import kotlinx.serialization.Serializable

@Serializable
data class DetailsRoute(
	val pizza: Pizza,
)