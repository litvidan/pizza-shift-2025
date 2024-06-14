package com.example.shiftintensivelivecoding

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shiftintensivelivecoding.data.LoanRepository
import com.example.shiftintensivelivecoding.history.HistoryRoute
import com.example.shiftintensivelivecoding.history.HistoryScreen

@Composable
fun MainScreen(repository: LoanRepository) {
	val navController = rememberNavController()

	Surface {
		NavHost(navController = navController, startDestination = HistoryRoute) {
			composable<HistoryRoute> {
				HistoryScreen(
					repository = repository,
					onItemSelected = { /*TODO Добавит навигацию на экран деталей*/ },
				)
			}
		}
	}
}