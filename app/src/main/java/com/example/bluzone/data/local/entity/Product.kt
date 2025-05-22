package com.example.bluzone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
   @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val photo: Int,
    val beforeDiscount: Double,
    val discount: Int,
    val rating: Int,
    val quantityInCart: Int = 0,
    val brand: String,
    val sku: String,
    val isFavorite: Boolean = false,
    val isInCart: Boolean = false,
)
