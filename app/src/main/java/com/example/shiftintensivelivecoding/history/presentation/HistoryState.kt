package com.example.shiftintensivelivecoding.history.presentation

import com.example.shiftintensivelivecoding.data.LoanHistoryItem

sealed interface HistoryState {

	data object Initial : HistoryState
	data object Loading : HistoryState
	data class Failure(val message: String?) : HistoryState
	data class Content(val loans: List<LoanHistoryItem>) : HistoryState
}