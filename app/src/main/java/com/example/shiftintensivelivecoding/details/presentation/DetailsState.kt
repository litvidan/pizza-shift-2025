package com.example.shiftintensivelivecoding.details.presentation

import com.example.shiftintensivelivecoding.details.domain.entity.Loan

interface DetailsState {

	data object Initial : DetailsState
	data object Loading : DetailsState
	data class Failure(val message: String?) : DetailsState
	data class Content(val loan: Loan) : DetailsState
}