package com.example.shiftintensivelivecoding

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.shiftintensivelivecoding.data.LoanRepository
import com.example.shiftintensivelivecoding.details.DetailsRoute
import com.example.shiftintensivelivecoding.details.DetailsScreen
import com.example.shiftintensivelivecoding.history.HistoryRoute
import com.example.shiftintensivelivecoding.history.HistoryScreen
import com.example.shiftintensivelivecoding.history.HistoryViewModel
import com.example.shiftintensivelivecoding.history.HistoryViewModelFactory

@Composable
fun MainScreen(repository: LoanRepository) {
	val navController = rememberNavController()

	Surface {
		NavHost(navController = navController, startDestination = HistoryRoute) {
			composable<HistoryRoute> {
				val viewModel: HistoryViewModel = viewModel(factory = HistoryViewModelFactory(repository))
				HistoryScreen(
					viewModel,
					onItemSelected = { navController.navigate(DetailsRoute(loanId = it)) },
				)
			}
			composable<DetailsRoute> {
				val destination = it.toRoute<DetailsRoute>()
				DetailsScreen(
					loanId = destination.loanId,
					repository = repository,
				)
			}
		}
	}
}