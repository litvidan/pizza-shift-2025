package com.example.shiftintensivelivecoding.details.data.repository

import com.example.shiftintensivelivecoding.details.data.converter.LoanConverter
import com.example.shiftintensivelivecoding.details.data.network.LoanApi
import com.example.shiftintensivelivecoding.details.domain.entity.Loan
import com.example.shiftintensivelivecoding.details.domain.repository.LoanRepository

class LoanRepositoryImpl(
	private val loanApi: LoanApi,
	private val loanConverter: LoanConverter,
) : LoanRepository {

	override suspend fun get(loanId: Long): Loan {
		val model = loanApi.get(loanId)
		return loanConverter.convert(model)
	}
}