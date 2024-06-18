package com.example.shiftintensivelivecoding.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shiftintensivelivecoding.data.LoanRepository

class HistoryViewModelFactory(
	private val loanRepository: LoanRepository,
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		require(modelClass == HistoryViewModel::class.java) { "Unknown ViewModel: $modelClass" }
		return HistoryViewModel(loanRepository) as T
	}
}