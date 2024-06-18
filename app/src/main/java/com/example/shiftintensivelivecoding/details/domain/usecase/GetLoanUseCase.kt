package com.example.shiftintensivelivecoding.details.domain.usecase

import com.example.shiftintensivelivecoding.details.domain.entity.Loan
import com.example.shiftintensivelivecoding.details.domain.repository.LoanRepository

class GetLoanUseCase(private val loanRepository: LoanRepository) {

	suspend operator fun invoke(loanId: Long): Loan =
		loanRepository.get(loanId)
}