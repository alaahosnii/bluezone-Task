package com.example.bluzone.ui.screens.productDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bluzone.data.local.entity.Product
import com.example.bluzone.data.local.respository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor (
    private val repository: ProductRepository,
    val dummyProducts: List<Product>
): ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        loadProducts()
    }
    private fun loadProducts(){
        viewModelScope.launch {
            _products.value = repository.getAllProducts()
        }
    }

    fun addToCart(product: Product , quantity: Int){
        viewModelScope.launch {
            val existingProduct = repository.getProductById(product.id)
            if (existingProduct != null) {
                val updatedProduct = existingProduct.copy(
                    isInCart = true,
                    quantityInCart = quantity
                )
                repository.updateProduct(updatedProduct)
            } else {
                val newProduct = product.copy(
                    isInCart = true,
                    quantityInCart = quantity
                )
                repository.insertProduct(newProduct)
            }
            loadProducts()
        }
    }

    fun toggleFavorite(product: Product){
        viewModelScope.launch {
            val existingProduct = repository.getProductById(product.id)
            if (existingProduct != null) {
                Log.d("ProductDetailsViewModel", "Product found: ${existingProduct.name}")
                val updatedProduct = existingProduct.copy(isFavorite = !existingProduct.isFavorite)
                Log.d("ProductDetailsViewModel", "Updated product: $updatedProduct")
                repository.updateProduct(updatedProduct)
            } else {
                Log.d("ProductDetailsViewModel", "Product not found: ${product.name}")
                val newProduct = product.copy(isFavorite = true)
                repository.insertProduct(newProduct)
            }
            loadProducts()
        }
    }

    fun toggleCart(product: Product){
        viewModelScope.launch {
            val updatedProduct = product.copy(isInCart = !product.isInCart)
            repository.updateProduct(updatedProduct)
            loadProducts()
        }
    }
}