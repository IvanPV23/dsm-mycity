package com.example.mycitylima.ui.state

import com.example.mycitylima.data.model.Category
import com.example.mycitylima.data.model.Place

data class MyCityUiState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null,
    val places: List<Place> = emptyList(),
    val selectedPlace: Place? = null,
    val isLoading: Boolean = false
)
