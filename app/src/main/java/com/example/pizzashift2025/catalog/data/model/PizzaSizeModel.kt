package com.example.pizzashift2025.catalog.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PizzaSizeModel(
    val size: PizzaSizesModel,
    val number: Int
)

enum class PizzaSizesModel {
    SMALL,
    MEDIUM,
    LARGE
}