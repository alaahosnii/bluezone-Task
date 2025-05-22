package com.example.bluzone.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bluzone.data.local.entity.Product

@Dao
interface ProductDao {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertProduct(product: Product)

     @Update
     suspend fun updateProduct(product: Product)

     @Query("SELECT * FROM products WHERE id = :productId")
     suspend fun getProductById(productId: String): Product?

     @Query("SELECT * FROM products")
     suspend fun getAllProducts(): List<Product>

    @Query("SELECT * FROM products WHERE isFavorite = 1")
    suspend fun getFavorites(): List<Product>

    @Query("SELECT * FROM products WHERE isInCart = 1")
    suspend fun getCartItems(): List<Product>

     @Delete
     suspend fun deleteProduct(product: Product)
}