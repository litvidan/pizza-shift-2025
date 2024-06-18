package com.example.shiftintensivelivecoding.details.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shiftintensivelivecoding.R
import com.example.shiftintensivelivecoding.details.domain.entity.Loan
import com.example.shiftintensivelivecoding.formatAmountText
import com.example.shiftintensivelivecoding.formatLoanStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun ContentComponent(
	loan: Loan,
) {
	Column {
		DetailItem(nameResId = R.string.details_last_name, value = loan.lastName)
		DetailItem(nameResId = R.string.details_first_name, value = loan.firstName)
		DetailItem(nameResId = R.string.details_amount, value = formatAmountText(loan.amount))
		DetailItem(nameResId = R.string.details_percent, value = stringResource(R.string.details_percent_pattern, loan.percent))
		DetailItem(nameResId = R.string.details_status, value = formatLoanStatus(loan.status))
		DetailItem(nameResId = R.string.details_phone, value = loan.phone)
		DetailItem(nameResId = R.string.details_issue_date, value = formatDate(loan.issueDate))
		DetailItem(nameResId = R.string.details_period, value = stringResource(R.string.details_period_pattern, loan.monthPeriod))
	}
}

@Composable
private fun DetailItem(@StringRes nameResId: Int, value: String) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 8.dp, horizontal = 16.dp),
	) {
		Text(text = stringResource(nameResId), style = MaterialTheme.typography.labelLarge)
		Text(text = value, style = MaterialTheme.typography.bodyLarge)
	}
}

fun formatDate(date: LocalDateTime): String =
	date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").withLocale(Locale.getDefault()))