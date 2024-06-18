package com.example.shiftintensivelivecoding.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shiftintensivelivecoding.history.domain.usecase.GetLoanHistoryItemsUseCase

class HistoryViewModelFactory(
	private val getLoanHistoryItemsUseCase: GetLoanHistoryItemsUseCase,
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		require(modelClass == HistoryViewModel::class.java) { "Unknown ViewModel: $modelClass" }
		return HistoryViewModel(getLoanHistoryItemsUseCase) as T
	}
}