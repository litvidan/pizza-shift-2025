package com.example.pizzashift2025.catalog.presentation

import com.example.pizzashift2025.catalog.domain.entity.PizzasCatalog

sealed interface CatalogState {

	data object Initial : CatalogState
	data object Loading : CatalogState
	data class Failure(val message: String?) : CatalogState
	data class Content(val catalog: PizzasCatalog) : CatalogState
}