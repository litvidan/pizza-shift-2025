package com.example.shiftintensivelivecoding.history.data.converter

import com.example.shiftintensivelivecoding.history.data.model.LoanHistoryItemModel
import com.example.shiftintensivelivecoding.history.domain.entity.LoanHistoryItem

class LoanHistoryItemConverter {

	fun convert(model: LoanHistoryItemModel): LoanHistoryItem =
		LoanHistoryItem(
			id = model.id,
			firstName = model.firstName,
			lastName = model.lastName,
			amount = model.amount,
			percent = model.percent,
			status = model.status,
		)
}