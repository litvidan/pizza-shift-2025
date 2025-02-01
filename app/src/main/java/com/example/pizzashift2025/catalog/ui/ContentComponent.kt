package com.example.pizzashift2025.catalog.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pizzashift2025.catalog.domain.entity.Pizza
import com.example.pizzashift2025.catalog.domain.entity.PizzasCatalog
import com.example.pizzashift2025.R


@Composable
fun ContentComponent(
	pizzas : PizzasCatalog,
	onItemClicked: (pizza: Pizza) -> Unit,
) {
	val pizzasList = pizzas.catalog

	LazyColumn(modifier = Modifier.fillMaxHeight()) {
		items(pizzasList) { pizza ->
			PizzaItem(
				pizza,
				onItemClicked = { onItemClicked(pizza) }
			)
		}
	}
}

@Composable
private fun PizzaItem(
	item: Pizza,
	onItemClicked: () -> Unit,
) {
	val sizes = item.sizes
	val minPrice = (sizes.minByOrNull {it.number })?.number ?: 0

	Row (
		Modifier
			.fillMaxWidth()
			.clickable(onClick = onItemClicked)
			.padding(vertical = 8.dp, horizontal = 16.dp)
	){
		AsyncImage(model = item.img, contentDescription = null, modifier = Modifier.size(100.dp))//Pizza image
		Column (Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center){
			Text(
				text = item.name,
				style = MaterialTheme.typography.bodyLarge
			) // Name
			Text(
				text = item.description,
				style = MaterialTheme.typography.bodyMedium
			) // Description
			Text(
				text = stringResource(R.string.price_pattern, minPrice)
			) // Price
		}

	}

}