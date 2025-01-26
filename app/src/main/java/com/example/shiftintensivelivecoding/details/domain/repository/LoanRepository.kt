package com.example.shiftintensivelivecoding.details.domain.repository

import com.example.shiftintensivelivecoding.details.domain.entity.Loan

interface LoanRepository {

	suspend fun get(loanId: Long): Loan
}