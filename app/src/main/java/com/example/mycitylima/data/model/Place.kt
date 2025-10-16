package com.example.mycitylima.data.model

data class Place(
    val id: Int,
    val name: String,
    val category: Category,
    val description: String,
    val imageUrl: String,
    val address: String,
    val rating: Double
)