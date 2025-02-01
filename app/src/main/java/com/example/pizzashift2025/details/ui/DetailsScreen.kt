package com.example.pizzashift2025.details.ui

import androidx.compose.runtime.Composable
import com.example.pizzashift2025.R
import com.example.pizzashift2025.catalog.domain.entity.Pizza

@Composable
fun DetailsScreen(
	pizza: Pizza?,
) {
	if(pizza == null){
		ErrorComponent(message = R.string.error_unknown_error.toString()) {

		}
	}
	else{
		ContentComponent(pizza = pizza)
	}
}