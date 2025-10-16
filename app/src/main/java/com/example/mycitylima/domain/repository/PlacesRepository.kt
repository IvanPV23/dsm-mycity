package com.example.mycitylima.domain.repository

import com.example.mycitylima.data.model.Category
import com.example.mycitylima.data.model.Place
import kotlinx.coroutines.flow.Flow

interface PlacesRepository {
    fun getCategories(): Flow<List<Category>>
    fun getPlacesByCategory(category: Category): Flow<List<Place>>
    fun getPlaceById(id: Int): Flow<Place?>
}