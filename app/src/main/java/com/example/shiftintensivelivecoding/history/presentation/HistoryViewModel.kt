package com.example.shiftintensivelivecoding.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftintensivelivecoding.history.domain.usecase.GetLoanHistoryItemsUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HistoryViewModel(
	private val getLoanHistoryItemsUseCase: GetLoanHistoryItemsUseCase,
) : ViewModel() {

	private val _state = MutableStateFlow<HistoryState>(HistoryState.Initial)
	val state: StateFlow<HistoryState> = _state

	fun loadLoans() {
		viewModelScope.launch {
			_state.value = HistoryState.Loading

			try {
				val loans = getLoanHistoryItemsUseCase()
				_state.value = HistoryState.Content(loans)
			} catch (ce: CancellationException) {
				throw ce
			} catch (ex: Exception) {
				_state.value = HistoryState.Failure(ex.localizedMessage.orEmpty())
			}
		}
	}
}