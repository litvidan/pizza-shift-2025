package com.example.pizzashift2025.catalog.data.converter

import com.example.pizzashift2025.catalog.data.model.IngredientNameModel
import com.example.pizzashift2025.catalog.data.model.PizzaDoughModel
import com.example.pizzashift2025.catalog.data.model.PizzaDoughsModel
import com.example.pizzashift2025.catalog.data.model.PizzaIngredientModel
import com.example.pizzashift2025.catalog.data.model.PizzaModel
import com.example.pizzashift2025.catalog.data.model.PizzaSizeModel
import com.example.pizzashift2025.catalog.data.model.PizzaSizesModel
import com.example.pizzashift2025.catalog.data.model.PizzasCatalogModel
import com.example.pizzashift2025.catalog.domain.entity.IngredientName
import com.example.pizzashift2025.catalog.domain.entity.Pizza
import com.example.pizzashift2025.catalog.domain.entity.PizzaDough
import com.example.pizzashift2025.catalog.domain.entity.PizzaDoughs
import com.example.pizzashift2025.catalog.domain.entity.PizzaIngredient
import com.example.pizzashift2025.catalog.domain.entity.PizzaSize
import com.example.pizzashift2025.catalog.domain.entity.PizzaSizes
import com.example.pizzashift2025.catalog.domain.entity.PizzasCatalog


class PizzasCatalogConverter {
    fun convertCatalog(model: PizzasCatalogModel) : PizzasCatalog =
        PizzasCatalog(
            success = model.success,
            reason = model.reason,
            catalog = model.catalog.map { convertPizza(it) }
        )
    
    fun convertPizza(model: PizzaModel) : Pizza = 
        Pizza(
            id = model.id,
            name = model.name,
            ingredients =  model.ingredients.map{convertIngredient(it)},
            toppings = model.toppings.map{convertIngredient(it)},
            description = model.description,
            sizes = model.sizes.map{convertPizzaSize(it)},
            doughs = model.doughs.map{convertPizzaDough(it)},
            calories = model.calories,
            protein = model.protein,
            totalFat = model.totalFat,
            carbohydrates =  model.carbohydrates,
            sodium = model.sodium,
            allergens = model.allergens,
            isVegetarian = model.isVegetarian,
            isGlutenFree = model.isGlutenFree,
            isNew = model.isNew,
            isHit = model.isHit,
            img = model.img
        )

    fun convertIngredient(model: PizzaIngredientModel) : PizzaIngredient =
        PizzaIngredient(
            name = convertIngredientName(model.name),
            cost = model.cost,
            img = model.img
        )

    // Дурацкая функция. перевод из двух одинаковых перечислений. Но, м.б.
    fun convertIngredientName(model: IngredientNameModel) : IngredientName =
        when(model){
            IngredientNameModel.PINEAPPLE -> IngredientName.PINEAPPLE
            IngredientNameModel.MOZZARELLA -> IngredientName.MOZZARELLA
            IngredientNameModel.PEPERONI -> IngredientName.PEPERONI
            IngredientNameModel.GREEN_PEPPER -> IngredientName.GREEN_PEPPER
            IngredientNameModel.MUSHROOMS -> IngredientName.MUSHROOMS
            IngredientNameModel.BASIL -> IngredientName.BASIL
            IngredientNameModel.CHEDDAR -> IngredientName.CHEDDAR
            IngredientNameModel.PARMESAN -> IngredientName.PARMESAN
            IngredientNameModel.FETA -> IngredientName.FETA
            IngredientNameModel.HAM -> IngredientName.HAM
            IngredientNameModel.PICKLE -> IngredientName.PICKLE
            IngredientNameModel.TOMATO -> IngredientName.TOMATO
            IngredientNameModel.BACON -> IngredientName.BACON
            IngredientNameModel.ONION -> IngredientName.ONION
            IngredientNameModel.CHILE -> IngredientName.CHILE
            IngredientNameModel.SHRIMPS -> IngredientName.SHRIMPS
            IngredientNameModel.CHICKEN_FILLET -> IngredientName.CHICKEN_FILLET
            IngredientNameModel.MEATBALLS -> IngredientName.MEATBALLS
            else -> IngredientName.UNKNOWN
        }

    // Тут такой же перевод, но я его поместил всё в ту же функцию
    fun convertPizzaSize(model: PizzaSizeModel) : PizzaSize =
        PizzaSize(
            size = when(model.size){
                PizzaSizesModel.SMALL -> PizzaSizes.SMALL
                PizzaSizesModel.LARGE -> PizzaSizes.LARGE
                PizzaSizesModel.MEDIUM -> PizzaSizes.MEDIUM
                else -> PizzaSizes.MEDIUM
            },
            number = model.number
        )

    fun convertPizzaDough(model: PizzaDoughModel) : PizzaDough =
        PizzaDough(
            name = when(model.name){
                PizzaDoughsModel.THIN -> PizzaDoughs.THIN
                PizzaDoughsModel.THICK -> PizzaDoughs.THICK
                else -> PizzaDoughs.THIN
            },
            number = model.number
        )

}