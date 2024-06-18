package com.example.shiftintensivelivecoding.history.data.model

import com.example.shiftintensivelivecoding.common.domain.LoanStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoanHistoryItemModel(
	val id: Long,
	@SerialName("first_name")
	val firstName: String,
	@SerialName("last_name")
	val lastName: String,
	val amount: Long,
	val percent: Double,
	val status: LoanStatus,
)