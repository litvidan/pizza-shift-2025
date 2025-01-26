package com.example.shiftintensivelivecoding.details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shiftintensivelivecoding.details.domain.usecase.GetLoanUseCase

class DetailsViewModelFactory(
	private val loanId: Long,
	private val getLoanUseCase: GetLoanUseCase,
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		require(modelClass == DetailsViewModel::class.java) { "Unknown ViewModel: $modelClass" }
		return DetailsViewModel(loanId, getLoanUseCase) as T
	}
}