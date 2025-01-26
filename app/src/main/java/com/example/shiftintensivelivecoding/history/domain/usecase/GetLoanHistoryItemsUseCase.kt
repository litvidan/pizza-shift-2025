package com.example.shiftintensivelivecoding.history.domain.usecase

import com.example.shiftintensivelivecoding.history.domain.entity.LoanHistoryItem
import com.example.shiftintensivelivecoding.history.domain.repository.LoanHistoryRepository

class GetLoanHistoryItemsUseCase(private val repository: LoanHistoryRepository) {

	suspend operator fun invoke(): List<LoanHistoryItem> =
		repository.getAll()
}