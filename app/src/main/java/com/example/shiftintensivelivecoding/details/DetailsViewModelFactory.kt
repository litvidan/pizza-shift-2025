package com.example.shiftintensivelivecoding.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shiftintensivelivecoding.data.LoanRepository

class DetailsViewModelFactory(
	private val loanId: Long,
	private val loanRepository: LoanRepository,
) : ViewModelProvider.Factory {

	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		require(modelClass == DetailsViewModel::class.java) { "Unknown ViewModel: $modelClass" }
		return DetailsViewModel(loanId, loanRepository) as T
	}
}