package com.example.shiftintensivelivecoding.history.domain.repository

import com.example.shiftintensivelivecoding.history.domain.entity.LoanHistoryItem

interface LoanHistoryRepository {

	suspend fun getAll(): List<LoanHistoryItem>
}