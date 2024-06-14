package com.example.shiftintensivelivecoding.data

import retrofit2.http.GET
import retrofit2.http.Path

interface LoansApi {

	@GET("loans")
	suspend fun getAll(): List<LoanHistoryItem>

	@GET("loans/{loanId}")
	suspend fun get(@Path("loanId") loanId: Long): Loan
}