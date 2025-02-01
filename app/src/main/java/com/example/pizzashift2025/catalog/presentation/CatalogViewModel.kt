package com.example.pizzashift2025.catalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift2025.catalog.domain.usecase.GetPizzasCatalogUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CatalogViewModel(
	private val getPizzasCatalogUseCase: GetPizzasCatalogUseCase,
) : ViewModel() {

	private val _state = MutableStateFlow<CatalogState>(CatalogState.Initial)
	val state: StateFlow<CatalogState> = _state

	fun loadCatalog() {
		viewModelScope.launch {
			_state.value = CatalogState.Loading

			try {
				val catalog = getPizzasCatalogUseCase()
				_state.value = CatalogState.Content(catalog)
			} catch (ce: CancellationException) {
				throw ce
			} catch (ex: Exception) {
				_state.value = CatalogState.Failure(ex.localizedMessage.orEmpty())
			}
		}
	}
}