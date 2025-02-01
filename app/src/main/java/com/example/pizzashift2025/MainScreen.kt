package com.example.pizzashift2025

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.pizzashift2025.details.DetailsRoute
import com.example.pizzashift2025.catalog.CatalogRoute
import com.example.pizzashift2025.catalog.domain.usecase.GetPizzasCatalogUseCase
import com.example.pizzashift2025.details.ui.DetailsScreen
import com.example.pizzashift2025.catalog.presentation.CatalogViewModel
import com.example.pizzashift2025.catalog.presentation.CatalogViewModelFactory
import com.example.pizzashift2025.catalog.ui.CatalogScreen

@Composable
fun MainScreen(
	getPizzasCatalogUseCase: GetPizzasCatalogUseCase
) {
	val navController = rememberNavController()

	Surface {
		NavHost(navController = navController, startDestination = CatalogRoute) {
			composable<CatalogRoute> {
				val viewModel: CatalogViewModel = viewModel(factory = CatalogViewModelFactory(getPizzasCatalogUseCase))
				CatalogScreen(
					viewModel,
					onItemSelected = {pizza ->
						navController.navigate(DetailsRoute(pizza)) },
				)
			}
			composable<DetailsRoute>{
				val args = it.toRoute<DetailsRoute>()
				DetailsScreen(
					pizza = args.pizza
				)
			}
		}
	}
}