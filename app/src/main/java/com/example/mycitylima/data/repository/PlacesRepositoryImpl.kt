package com.example.mycitylima.data.repository

import com.example.mycitylima.data.local.PlacesDataSource
import com.example.mycitylima.data.model.Category
import com.example.mycitylima.data.model.Place
import com.example.mycitylima.domain.repository.PlacesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlacesRepositoryImpl : PlacesRepository {
    override fun getCategories(): Flow<List<Category>> = flow {
        emit(PlacesDataSource.getCategories())
    }

    override fun getPlacesByCategory(category: Category): Flow<List<Place>> = flow {
        emit(PlacesDataSource.getPlacesByCategory(category))
    }

    override fun getPlaceById(id: Int): Flow<Place?> = flow {
        emit(PlacesDataSource.getPlaces().find { it.id == id })
    }
}