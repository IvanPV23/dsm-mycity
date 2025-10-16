package com.example.mycitylima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.mycitylima.ui.screen.MyCityApp
import com.example.mycitylima.ui.theme.MyCityLimaTheme
import com.example.mycitylima.ui.viewmodel.MyCityViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityLimaTheme {
                val windowSize = calculateWindowSizeClass(this)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyCityAppScreen(
                        windowSize = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}

@Composable
fun MyCityAppScreen(
    windowSize: androidx.compose.material3.windowsizeclass.WindowWidthSizeClass,
    viewModel: MyCityViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    MyCityApp(
        windowSize = windowSize,
        uiState = uiState,
        onCategorySelect = { category ->
            viewModel.selectCategory(category)
        },
        onPlaceSelect = { placeId ->
            viewModel.selectPlace(placeId)
        },
        onBackToCategories = {
            viewModel.clearCategorySelection()
        },
        onBackToPlaces = {
            viewModel.clearPlaceSelection()
        }
    )
}