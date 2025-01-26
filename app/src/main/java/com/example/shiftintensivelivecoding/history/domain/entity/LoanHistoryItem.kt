package com.example.shiftintensivelivecoding.history.domain.entity

import com.example.shiftintensivelivecoding.common.domain.LoanStatus

data class LoanHistoryItem(
	val id: Long,
	val firstName: String,
	val lastName: String,
	val amount: Long,
	val percent: Double,
	val status: LoanStatus,
)