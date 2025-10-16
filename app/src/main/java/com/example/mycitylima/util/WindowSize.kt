package com.example.mycitylima.util

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

enum class NavigationType {
    BOTTOM_NAVIGATION,
    NAVIGATION_RAIL,
    PERMANENT_NAVIGATION_DRAWER
}

enum class ContentType {
    LIST_ONLY,
    LIST_AND_DETAIL
}

fun WindowWidthSizeClass.getNavigationType(): NavigationType {
    return when (this) {
        WindowWidthSizeClass.Compact -> NavigationType.BOTTOM_NAVIGATION
        WindowWidthSizeClass.Medium -> NavigationType.NAVIGATION_RAIL
        WindowWidthSizeClass.Expanded -> NavigationType.PERMANENT_NAVIGATION_DRAWER
        else -> NavigationType.BOTTOM_NAVIGATION
    }
}

fun WindowWidthSizeClass.getContentType(): ContentType {
    return when (this) {
        WindowWidthSizeClass.Compact -> ContentType.LIST_ONLY
        WindowWidthSizeClass.Medium -> ContentType.LIST_ONLY
        WindowWidthSizeClass.Expanded -> ContentType.LIST_AND_DETAIL
        else -> ContentType.LIST_ONLY
    }
}