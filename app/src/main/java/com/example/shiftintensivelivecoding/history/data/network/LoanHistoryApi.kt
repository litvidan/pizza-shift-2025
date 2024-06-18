package com.example.shiftintensivelivecoding.history.data.network

import com.example.shiftintensivelivecoding.history.data.model.LoanHistoryItemModel
import retrofit2.http.GET

interface LoanHistoryApi {

	@GET("loans")
	suspend fun getAll(): List<LoanHistoryItemModel>
}