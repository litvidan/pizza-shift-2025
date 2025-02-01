package com.example.pizzashift2025.catalog.domain.repository

import com.example.pizzashift2025.catalog.domain.entity.PizzasCatalog

interface PizzasCatalogRepository {
    suspend fun getAll(): PizzasCatalog
}