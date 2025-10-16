package com.example.mycitylima.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.mycitylima.data.model.Category
import com.example.mycitylima.util.ContentType
import com.example.mycitylima.util.NavigationType
import com.example.mycitylima.util.getContentType
import com.example.mycitylima.util.getNavigationType

@Composable
fun NavigationWrapper(
    windowSize: WindowWidthSizeClass,
    content: @Composable (PaddingValues) -> Unit
) {
    val navigationType = windowSize.getNavigationType()
    val contentType = windowSize.getContentType()

    when (navigationType) {
        NavigationType.BOTTOM_NAVIGATION -> {
            content(PaddingValues(0.dp))
        }
        NavigationType.NAVIGATION_RAIL -> {
            Row {
                NavigationRail(
                    modifier = Modifier.width(80.dp)
                ) {
                    // Navigation rail content can be added here if needed
                }
                content(PaddingValues(start = 80.dp))
            }
        }
        NavigationType.PERMANENT_NAVIGATION_DRAWER -> {
            Row {
                PermanentNavigationDrawer(
                    drawerContent = {
                        PermanentDrawerSheet(
                            modifier = Modifier.width(240.dp)
                        ) {
                            Spacer(Modifier.height(12.dp))
                            Text(
                                text = "Mi Ciudad Lima",
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(16.dp)
                            )
                            Divider()
                        }
                    }
                ) {
                    content(PaddingValues(start = 240.dp))
                }
            }
        }
    }
}
