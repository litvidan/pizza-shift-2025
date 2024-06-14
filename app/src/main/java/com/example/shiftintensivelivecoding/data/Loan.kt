package com.example.shiftintensivelivecoding.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Loan(
	val id: Long,
	@SerialName("first_name")
	val firstName: String,
	@SerialName("last_name")
	val lastName: String,
	val amount: Long,
	val percent: Double,
	val status: LoanStatus,
	val phone: String,
	@SerialName("date")
	val issueDate: String,
	@SerialName("period")
	val monthPeriod: Int,
)