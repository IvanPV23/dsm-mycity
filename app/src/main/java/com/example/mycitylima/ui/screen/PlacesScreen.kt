package com.example.mycitylima.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycitylima.data.model.Category
import com.example.mycitylima.data.model.Place
import com.example.mycitylima.ui.component.PlaceCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacesScreen(
    category: Category,
    places: List<Place>,
    onPlaceClick: (Int) -> Unit,
    onBackClick: () -> Unit,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(category.displayName) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        }
    ) { padding ->
        if (places.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("No hay lugares disponibles")
            }
        } else {
            when (windowSize) {
                WindowWidthSizeClass.Compact -> {
                    // Teléfonos: Lista vertical de cards completas
                    LazyColumn(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(places) { place ->
                            PlaceCard(
                                place = place,
                                onClick = { onPlaceClick(place.id) },
                                isCompact = false
                            )
                        }
                    }
                }
                WindowWidthSizeClass.Medium -> {
                    // Tablets pequeñas: Grid de 2 columnas
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(places) { place ->
                            PlaceCard(
                                place = place,
                                onClick = { onPlaceClick(place.id) },
                                isCompact = true
                            )
                        }
                    }
                }
                WindowWidthSizeClass.Expanded -> {
                    // Tablets grandes: Grid de 3 columnas (o 2 si está en split view)
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 280.dp),
                        modifier = modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(20.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        items(places) { place ->
                            PlaceCard(
                                place = place,
                                onClick = { onPlaceClick(place.id) },
                                isCompact = true
                            )
                        }
                    }
                }
                else -> {
                    LazyColumn(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(places) { place ->
                            PlaceCard(
                                place = place,
                                onClick = { onPlaceClick(place.id) },
                                isCompact = false
                            )
                        }
                    }
                }
            }
        }
    }
}
