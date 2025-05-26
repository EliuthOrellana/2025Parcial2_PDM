package com.p2pdm.parcial2.model


data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val description: String,
    val imageUrl: String,
    var addedToCart: Boolean
)