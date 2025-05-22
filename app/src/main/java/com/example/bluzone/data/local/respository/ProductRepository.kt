package com.example.bluzone.data.local.respository

import com.example.bluzone.data.local.dao.ProductDao
import com.example.bluzone.data.local.entity.Product
import javax.inject.Inject


class ProductRepository @Inject constructor (
    private val dao: ProductDao
) {
    suspend fun insertProduct(product: Product) {
        dao.insertProduct(product)
    }

    suspend fun updateProduct(product: Product) {
        dao.updateProduct(product)
    }

    suspend fun getProductById(productId: String): Product? {
        return dao.getProductById(productId)
    }

    suspend fun getAllProducts(): List<Product> {
        return dao.getAllProducts()
    }

    suspend fun getFavorites(): List<Product> {
        return dao.getFavorites()
    }

    suspend fun getCartItems(): List<Product> {
        return dao.getCartItems()
    }

    suspend fun deleteProduct(product: Product) {
        dao.deleteProduct(product)
    }
}