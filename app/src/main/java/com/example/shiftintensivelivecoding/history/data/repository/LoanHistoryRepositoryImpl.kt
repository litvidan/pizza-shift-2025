package com.example.shiftintensivelivecoding.history.data.repository

import com.example.shiftintensivelivecoding.history.data.converter.LoanHistoryItemConverter
import com.example.shiftintensivelivecoding.history.data.network.LoanHistoryApi
import com.example.shiftintensivelivecoding.history.domain.entity.LoanHistoryItem
import com.example.shiftintensivelivecoding.history.domain.repository.LoanHistoryRepository

class LoanHistoryRepositoryImpl(
	private val loanHistoryApi: LoanHistoryApi,
	private val loanHistoryItemConverter: LoanHistoryItemConverter,
) : LoanHistoryRepository {

	override suspend fun getAll(): List<LoanHistoryItem> {
		val models = loanHistoryApi.getAll()
		return models.map { loanHistoryItemConverter.convert(it) }
	}
}