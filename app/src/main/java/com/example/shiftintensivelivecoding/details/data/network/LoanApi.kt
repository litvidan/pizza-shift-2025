package com.example.shiftintensivelivecoding.details.data.network

import com.example.shiftintensivelivecoding.details.data.model.LoanModel
import retrofit2.http.GET
import retrofit2.http.Path

interface LoanApi {

	@GET("loans/{loanId}")
	suspend fun get(@Path("loanId") loanId: Long): LoanModel
}