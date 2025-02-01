package com.example.pizzashift2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pizzashift2025.catalog.data.converter.PizzasCatalogConverter
import com.example.pizzashift2025.catalog.data.network.PizzasCatalogApi
import com.example.pizzashift2025.catalog.data.repository.PizzasCatalogRepositoryImpl
import com.example.pizzashift2025.catalog.domain.repository.PizzasCatalogRepository
import com.example.pizzashift2025.catalog.domain.usecase.GetPizzasCatalogUseCase
import com.example.pizzashift2025.ui.theme.ShiftPizzaTheme

class MainActivity : ComponentActivity() {
	private val networkModule = NetworkModule()

	private val pizzasCatalogApi : PizzasCatalogApi = networkModule.retrofit.create(PizzasCatalogApi::class.java)
	private val pizzasCatalogConverter : PizzasCatalogConverter = PizzasCatalogConverter()
	private val pizzasCatalogRepository : PizzasCatalogRepository = PizzasCatalogRepositoryImpl(pizzasCatalogApi, pizzasCatalogConverter)
	private val getPizzasCatalogUseCase = GetPizzasCatalogUseCase(pizzasCatalogRepository)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ShiftPizzaTheme {
				MainScreen(
					getPizzasCatalogUseCase = getPizzasCatalogUseCase,
				)
			}
		}
	}
}