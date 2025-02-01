package com.example.pizzashift2025.catalog.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PizzaDoughModel (
    val name: PizzaDoughsModel,
    val number: Int
)

enum class PizzaDoughsModel{
    THIN,
    THICK
}

