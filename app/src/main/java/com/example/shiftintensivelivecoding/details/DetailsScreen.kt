package com.example.shiftintensivelivecoding.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shiftintensivelivecoding.R

@Composable
fun DetailsScreen(
	viewModel: DetailsViewModel,
) {
	val detailsState by viewModel.state.collectAsState()

	LaunchedEffect(Unit) {
		viewModel.loadLoan()
	}

	Column(modifier = Modifier.fillMaxSize()) {
		Text(
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 12.dp, horizontal = 8.dp),
			text = stringResource(id = R.string.details_title),
			style = MaterialTheme.typography.titleLarge,
		)

		when (val state = detailsState) {
			is DetailsState.Initial,
			is DetailsState.Loading -> LoadingComponent()

			is DetailsState.Failure -> ErrorComponent(
				message = state.message ?: stringResource(id = R.string.error_unknown_error),
				onRetry = {
					viewModel.loadLoan()
				}
			)

			is DetailsState.Content -> ContentComponent(
				loan = state.loan,
			)
		}
	}
}