package com.example.pizzashift2025.catalog.domain.usecase

import com.example.pizzashift2025.catalog.domain.entity.PizzasCatalog
import com.example.pizzashift2025.catalog.domain.repository.PizzasCatalogRepository

class GetPizzasCatalogUseCase(private val repository: PizzasCatalogRepository) {
    suspend operator fun invoke(): PizzasCatalog =
        repository.getAll()
}