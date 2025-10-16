package com.example.mycitylima.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.mycitylima.ui.state.MyCityUiState
import com.example.mycitylima.ui.component.PlaceDetail
import com.example.mycitylima.util.ContentType
import com.example.mycitylima.util.getContentType

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    uiState: MyCityUiState,
    onCategorySelect: (com.example.mycitylima.data.model.Category) -> Unit,
    onPlaceSelect: (Int) -> Unit,
    onBackToCategories: () -> Unit,
    onBackToPlaces: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentType = windowSize.getContentType()

    when {
        // Pantalla de detalle en modo expandido (lado a lado con lista)
        uiState.selectedPlace != null && contentType == ContentType.LIST_AND_DETAIL -> {
            Row(modifier = modifier.fillMaxSize()) {
                // Lista de lugares ocupa 40% del ancho
                Box(modifier = Modifier.weight(0.4f)) {
                    PlacesScreen(
                        category = uiState.selectedCategory!!,
                        places = uiState.places,
                        onPlaceClick = onPlaceSelect,
                        onBackClick = onBackToCategories,
                        windowSize = windowSize,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Detalle ocupa 60% del ancho
                Box(modifier = Modifier.weight(0.6f)) {
                    PlaceDetail(
                        place = uiState.selectedPlace,
                        onBackClick = onBackToPlaces,
                        showBackButton = false,
                        windowSize = windowSize,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        // Pantalla de detalle (solo en modo compacto/medio)
        uiState.selectedPlace != null && contentType == ContentType.LIST_ONLY -> {
            PlaceDetail(
                place = uiState.selectedPlace,
                onBackClick = onBackToPlaces,
                showBackButton = true,
                windowSize = windowSize
            )
        }

        // Pantalla de lugares sin detalle en modo expandido
        uiState.selectedCategory != null && contentType == ContentType.LIST_AND_DETAIL -> {
            Row(modifier = modifier.fillMaxSize()) {
                Box(modifier = Modifier.weight(0.4f)) {
                    PlacesScreen(
                        category = uiState.selectedCategory,
                        places = uiState.places,
                        onPlaceClick = onPlaceSelect,
                        onBackClick = onBackToCategories,
                        windowSize = windowSize,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(0.6f)
                        .fillMaxHeight(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    androidx.compose.material3.Text(
                        text = "Selecciona un lugar para ver los detalles",
                        style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                        color = androidx.compose.material3.MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Pantalla de lugares (modo compacto/medio)
        uiState.selectedCategory != null -> {
            PlacesScreen(
                category = uiState.selectedCategory,
                places = uiState.places,
                onPlaceClick = onPlaceSelect,
                onBackClick = onBackToCategories,
                windowSize = windowSize
            )
        }

        // Pantalla de categorías
        else -> {
            CategoriesScreen(
                categories = uiState.categories,
                onCategoryClick = onCategorySelect,
                windowSize = windowSize
            )
        }
    }
}