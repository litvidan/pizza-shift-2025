package com.example.pizzashift2025.catalog.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class PizzaDough (
    val name: PizzaDoughs,
    val number: Int
)

enum class PizzaDoughs{
    THIN,
    THICK
}

