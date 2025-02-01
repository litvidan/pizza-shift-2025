package com.example.pizzashift2025.catalog.data.repository

import com.example.pizzashift2025.catalog.data.converter.PizzasCatalogConverter
import com.example.pizzashift2025.catalog.data.network.PizzasCatalogApi
import com.example.pizzashift2025.catalog.domain.entity.PizzasCatalog
import com.example.pizzashift2025.catalog.domain.repository.PizzasCatalogRepository


class PizzasCatalogRepositoryImpl(
    private val pizzasCatalogApi: PizzasCatalogApi,
    private val pizzasCatalogConverter: PizzasCatalogConverter
) : PizzasCatalogRepository{
    override suspend fun getAll(): PizzasCatalog {
        val pizzas = pizzasCatalogApi.getAll()
        return pizzasCatalogConverter.convertCatalog(pizzas)
    }
}