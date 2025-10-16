package com.example.mycitylima.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mycitylima.data.model.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetail(
    place: Place,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    showBackButton: Boolean = true,
    windowSize: WindowWidthSizeClass = WindowWidthSizeClass.Compact
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        if (showBackButton) {
            TopAppBar(
                title = { Text("Detalles") },
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

        // Imagen adaptativa según tamaño de pantalla
        AsyncImage(
            model = place.imageUrl,
            contentDescription = place.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    when (windowSize) {
                        WindowWidthSizeClass.Compact -> 240.dp
                        WindowWidthSizeClass.Medium -> 320.dp
                        WindowWidthSizeClass.Expanded -> 400.dp
                        else -> 240.dp
                    }
                ),
            contentScale = ContentScale.Crop
        )

        // Contenido con padding adaptativo
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    when (windowSize) {
                        WindowWidthSizeClass.Compact -> 16.dp
                        WindowWidthSizeClass.Medium -> 24.dp
                        WindowWidthSizeClass.Expanded -> 32.dp
                        else -> 16.dp
                    }
                )
        ) {
            Text(
                text = place.name,
                style = when (windowSize) {
                    WindowWidthSizeClass.Compact -> MaterialTheme.typography.headlineMedium
                    WindowWidthSizeClass.Medium -> MaterialTheme.typography.headlineLarge
                    WindowWidthSizeClass.Expanded -> MaterialTheme.typography.displaySmall
                    else -> MaterialTheme.typography.headlineMedium
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = place.category.displayName,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }

                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    Text(
                        text = "⭐",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = place.rating.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Card para la dirección
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "📍 Dirección",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = place.address,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Divider()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Acerca de este lugar",
                style = when (windowSize) {
                    WindowWidthSizeClass.Compact -> MaterialTheme.typography.titleLarge
                    else -> MaterialTheme.typography.headlineSmall
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = place.description,
                style = when (windowSize) {
                    WindowWidthSizeClass.Compact -> MaterialTheme.typography.bodyLarge
                    else -> MaterialTheme.typography.bodyLarge
                },
                lineHeight = when (windowSize) {
                    WindowWidthSizeClass.Compact -> MaterialTheme.typography.bodyLarge.lineHeight
                    else -> MaterialTheme.typography.bodyLarge.lineHeight * 1.2f
                }
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}