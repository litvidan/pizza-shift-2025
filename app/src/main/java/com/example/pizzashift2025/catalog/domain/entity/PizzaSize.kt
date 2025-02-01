package com.example.pizzashift2025.catalog.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class PizzaSize(
    val size: PizzaSizes,
    val number: Int
)

enum class PizzaSizes {
    SMALL,
    MEDIUM,
    LARGE
}