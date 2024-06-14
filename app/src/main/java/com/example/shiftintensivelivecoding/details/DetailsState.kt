package com.example.shiftintensivelivecoding.details

import com.example.shiftintensivelivecoding.data.Loan

interface DetailsState {

	data object Initial : DetailsState
	data object Loading : DetailsState
	data class Failure(val message: String?) : DetailsState
	data class Content(val loan: Loan) : DetailsState
}