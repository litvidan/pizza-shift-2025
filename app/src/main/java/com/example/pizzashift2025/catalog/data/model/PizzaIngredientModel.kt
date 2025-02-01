package com.example.pizzashift2025.catalog.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PizzaIngredientModel (
    val name: IngredientNameModel,
    val cost: Int,
    val img: String
)

enum class IngredientNameModel {
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
        fun fromString(value: String): IngredientNameModel {
            return try {
                valueOf(value)
            } catch (e: IllegalArgumentException) {
                UNKNOWN
            }
        }
    }
}