package com.example.shiftintensivelivecoding.history.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shiftintensivelivecoding.R
import com.example.shiftintensivelivecoding.data.LoanHistoryItem
import com.example.shiftintensivelivecoding.formatAmountText
import com.example.shiftintensivelivecoding.formatLoanStatus

@Composable
fun ContentComponent(
	loans: List<LoanHistoryItem>,
	onItemClicked: (loanId: Long) -> Unit,
) {
	LazyColumn(modifier = Modifier.fillMaxHeight()) {
		items(loans) { loan ->
			LoanItem(
				loan,
				onItemClicked = { onItemClicked(loan.id) }
			)
		}
	}
}

@Composable
private fun LoanItem(
	item: LoanHistoryItem,
	onItemClicked: () -> Unit,
) {
	Column (
		Modifier
			.fillMaxWidth()
			.clickable(onClick = onItemClicked)
			.padding(vertical = 8.dp, horizontal = 16.dp)
	) {
		Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
			Text(
				text = formatBorrowerName(firstName = item.firstName, lastName = item.lastName),
				style = MaterialTheme.typography.bodyLarge,
			)
			Text(
				text = formatLoanStatus(status = item.status),
				style = MaterialTheme.typography.bodyLarge,
			)
		}
		Text(
			text = stringResource(R.string.history_amount_with_percent_pattern, formatAmountText(amount = item.amount), item.percent),
			style = MaterialTheme.typography.bodyMedium,
		)
	}
}

@Composable
fun formatBorrowerName(firstName: String, lastName: String): String =
	stringResource(id = R.string.history_name_pattern, lastName, firstName.take(1))