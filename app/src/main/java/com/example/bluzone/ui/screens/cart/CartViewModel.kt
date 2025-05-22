package com.example.bluzone.ui.screens.cart

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
class CartViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {
    private val _cartProducts = MutableStateFlow<List<Product>>(emptyList())
    val cartProducts: StateFlow<List<Product>> = _cartProducts

    init {
        loadCartProducts()
    }

    private fun loadCartProducts() {
        viewModelScope.launch {
            _cartProducts.value = repository.getAllProducts().filter { it.isInCart }
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
            loadCartProducts()
        }
    }

    private fun updateCartProduct(product: Product, quantity: Int) {
        viewModelScope.launch {
            val updatedProduct = product.copy(quantityInCart = quantity, isInCart = quantity > 0)
            repository.updateProduct(updatedProduct)
            loadCartProducts()
        }
    }

    fun removeFromCart(product: Product) {
        updateCartProduct(product, 0)
    }
}

