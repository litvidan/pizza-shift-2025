package com.example.shiftintensivelivecoding

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.shiftintensivelivecoding.details.DetailsRoute
import com.example.shiftintensivelivecoding.history.HistoryRoute
import com.example.shiftintensivelivecoding.details.domain.usecase.GetLoanUseCase
import com.example.shiftintensivelivecoding.details.presentation.DetailsViewModel
import com.example.shiftintensivelivecoding.details.presentation.DetailsViewModelFactory
import com.example.shiftintensivelivecoding.details.ui.DetailsScreen
import com.example.shiftintensivelivecoding.history.domain.usecase.GetLoanHistoryItemsUseCase
import com.example.shiftintensivelivecoding.history.presentation.HistoryViewModel
import com.example.shiftintensivelivecoding.history.presentation.HistoryViewModelFactory
import com.example.shiftintensivelivecoding.history.ui.HistoryScreen

@Composable
fun MainScreen(
	getLoanHistoryItemsUseCase: GetLoanHistoryItemsUseCase,
	getLoanUseCase: GetLoanUseCase,
) {
	val navController = rememberNavController()

	Surface {
		NavHost(navController = navController, startDestination = HistoryRoute) {
			composable<HistoryRoute> {
				val viewModel: HistoryViewModel = viewModel(factory = HistoryViewModelFactory(getLoanHistoryItemsUseCase))
				HistoryScreen(
					viewModel,
					onItemSelected = { navController.navigate(DetailsRoute(loanId = it)) },
				)
			}
			composable<DetailsRoute> {
				val destination = it.toRoute<DetailsRoute>()
				val viewModel = viewModel(DetailsViewModel::class.java, factory = DetailsViewModelFactory(destination.loanId, getLoanUseCase))
				DetailsScreen(
					viewModel
				)
			}
		}
	}
}