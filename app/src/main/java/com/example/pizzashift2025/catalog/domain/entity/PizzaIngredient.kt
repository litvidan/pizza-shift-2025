package com.example.pizzashift2025.catalog.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class PizzaIngredient (
    val name: IngredientName,
    val cost: Int,
    val img: String
)

enum class IngredientName {
    PINEAPPLE,
    MOZZARELLA,
    PEPERONI,
    GREEN_PEPPER,
    MUSHROOMS,
    BASIL,
    CHEDDAR,
    PARMESAN,
    FETA,
    HAM,
    PICKLE,
    TOMATO,
    BACON,
    ONION,
    CHILE,
    SHRIMPS,
    CHICKEN_FILLET,
    MEATBALLS,
    UNKNOWN;

    companion object {
        fun fromString(value: String): IngredientName {
            return try {
                valueOf(value)
            } catch (e: IllegalArgumentException) {
                UNKNOWN
            }
        }
    }
}