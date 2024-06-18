package com.example.shiftintensivelivecoding.details.domain.entity

import com.example.shiftintensivelivecoding.common.domain.LoanStatus
import java.time.LocalDateTime

data class Loan(
	val id: Long,
	val firstName: String,
	val lastName: String,
	val amount: Long,
	val percent: Double,
	val status: LoanStatus,
	val phone: String,
	val issueDate: LocalDateTime,
	val monthPeriod: Int,
)