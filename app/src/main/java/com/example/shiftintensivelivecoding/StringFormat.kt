package com.example.shiftintensivelivecoding

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.shiftintensivelivecoding.common.domain.LoanStatus
import java.text.NumberFormat
import java.util.Locale
import com.example.shiftintensivelivecoding.data.LoanStatus as OldLoanStatus

@Composable
fun formatAmountText(amount: Long): String {
	val numberFormatter = NumberFormat.getNumberInstance(Locale.getDefault())
	return numberFormatter.format(amount) + stringResource(R.string.ruble)
}

@Composable
fun formatLoanStatus(status: LoanStatus): String =
	when (status) {
		LoanStatus.APPROVED   -> stringResource(R.string.approved)
		LoanStatus.REGISTERED -> stringResource(R.string.registered)
		LoanStatus.REJECTED   -> stringResource(R.string.rejected)
	}

@Composable
fun formatLoanStatus(status: OldLoanStatus): String =
	when (status) {
		OldLoanStatus.APPROVED   -> stringResource(R.string.approved)
		OldLoanStatus.REGISTERED -> stringResource(R.string.registered)
		OldLoanStatus.REJECTED   -> stringResource(R.string.rejected)
	}