package com.example.shiftintensivelivecoding.data

import retrofit2.http.GET

interface LoansApi {

	@GET("loans")
	suspend fun getAll(): List<LoanHistoryItem>
}