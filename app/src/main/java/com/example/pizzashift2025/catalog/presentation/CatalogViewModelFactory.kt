package com.example.pizzashift2025.catalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pizzashift2025.catalog.domain.usecase.GetPizzasCatalogUseCase

class CatalogViewModelFactory(
	private val getPizzasCatalogUseCase: GetPizzasCatalogUseCase,
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		require(modelClass == CatalogViewModel::class.java) { "Unknown ViewModel: $modelClass" }
		return CatalogViewModel(getPizzasCatalogUseCase) as T
	}
}