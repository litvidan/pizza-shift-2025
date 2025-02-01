package com.example.pizzashift2025.details.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pizzashift2025.R
import com.example.pizzashift2025.catalog.domain.entity.Pizza
import com.example.pizzashift2025.catalog.domain.entity.PizzaSize


@Composable
fun ContentComponent(
	pizza: Pizza,
) {
	// Состояние для выбранного размера
	var selectedSize by remember { mutableStateOf(pizza.sizes.firstOrNull()) }

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp)
	) {
		// Изображение пиццы
		AsyncImage(
			model = stringResource(R.string.api_base, pizza.img),
			contentDescription = null,
			modifier = Modifier
				.fillMaxWidth()
				.height(200.dp)
		)

		// Название пиццы
		Text(
			text = pizza.name,
			style = MaterialTheme.typography.bodyLarge,
			modifier = Modifier.padding(top = 16.dp)
		)

		// Переключатель размеров
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 16.dp),
			horizontalArrangement = Arrangement.SpaceEvenly
		) {
			pizza.sizes.forEach { size ->
				SizeButton(
					size = size,
					isSelected = size == selectedSize,
					onClick = { selectedSize = size }
				)
			}
		}

		// Описание и цена выбранного размера
		selectedSize?.let { size ->
			Text(
				text = "Размер: ${size.size}",
				style = MaterialTheme.typography.bodySmall,
				modifier = Modifier.padding(top = 8.dp)
			)
			Text(
				text = "Цена: ${size.number} руб.",
				style = MaterialTheme.typography.bodyMedium,
				modifier = Modifier.padding(top = 4.dp)
			)
		}

		// Описание пиццы
		Text(
			text = pizza.description,
			style = MaterialTheme.typography.bodySmall,
			modifier = Modifier.padding(top = 16.dp)
		)
	}
}

@Composable
fun SizeButton(
	size: PizzaSize,
	isSelected: Boolean,
	onClick: () -> Unit
) {
	Button(
		onClick = onClick,
		shape = RoundedCornerShape(8.dp),
		colors = ButtonDefaults.buttonColors(
			containerColor = if (isSelected) Color.Blue else Color.LightGray,
			contentColor = if (isSelected) Color.White else Color.Black
		),
		modifier = Modifier.padding(4.dp)
	) {
		Text(text = size.size.toString())
	}
}