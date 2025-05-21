package com.example.bluzone.data.models

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val photo: Int,
    val beforeDiscount: Double,
    val discount: Int,
    val rating: Int,
    val brand: String,
    val sku: String,
)
