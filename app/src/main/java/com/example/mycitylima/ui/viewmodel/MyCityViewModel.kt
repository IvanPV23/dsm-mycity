package com.example.mycitylima.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycitylima.data.model.Category
import com.example.mycitylima.domain.repository.PlacesRepository
import com.example.mycitylima.ui.state.MyCityUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyCityViewModel(
    private val repository: PlacesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            repository.getCategories().collect { categories ->
                _uiState.update {
                    it.copy(
                        categories = categories,
                        isLoading = false
                    )
                }
            }
        }
    }

    fun selectCategory(category: Category) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, selectedCategory = category) }
            repository.getPlacesByCategory(category).collect { places ->
                _uiState.update {
                    it.copy(
                        places = places,
                        isLoading = false,
                        selectedPlace = null
                    )
                }
            }
        }
    }

    fun selectPlace(placeId: Int) {
        viewModelScope.launch {
            repository.getPlaceById(placeId).collect { place ->
                _uiState.update { it.copy(selectedPlace = place) }
            }
        }
    }

    fun clearPlaceSelection() {
        _uiState.update { it.copy(selectedPlace = null) }
    }

    fun clearCategorySelection() {
        _uiState.update {
            it.copy(
                selectedCategory = null,
                places = emptyList(),
                selectedPlace = null
            )
        }
    }
}
