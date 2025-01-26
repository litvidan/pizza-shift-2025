package com.example.shiftintensivelivecoding.details.data.converter

import com.example.shiftintensivelivecoding.details.data.model.LoanModel
import com.example.shiftintensivelivecoding.details.domain.entity.Loan

class LoanConverter {

	fun convert(model: LoanModel): Loan =
		Loan(
			id = model.id,
			firstName = model.firstName,
			lastName = model.lastName,
			amount = model.amount,
			percent = model.percent,
			status = model.status,
			phone = model.phone,
			issueDate = model.issueDate,
			monthPeriod = model.monthPeriod,
		)
}