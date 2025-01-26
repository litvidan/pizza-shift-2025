package com.example.shiftintensivelivecoding.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftintensivelivecoding.details.domain.usecase.GetLoanUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class DetailsViewModel(
	private val loanId: Long,
	private val getLoanUseCase: GetLoanUseCase,
) : ViewModel() {

	private val _state = MutableStateFlow<DetailsState>(DetailsState.Initial)
	val state: StateFlow<DetailsState> = _state

	fun loadLoan() {
		viewModelScope.launch {
			_state.value = DetailsState.Loading

			try {
				val loan = getLoanUseCase(loanId)
				_state.value = DetailsState.Content(loan)
			} catch (ce: CancellationException) {
				throw ce
			} catch (ex: Exception) {
				_state.value = DetailsState.Failure(ex.message)
			}
		}
	}
}