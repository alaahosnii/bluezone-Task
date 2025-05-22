package com.example.bluzone.ui.components.productCard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bluzone.data.local.entity.Product
import com.example.bluzone.ui.screens.cart.CartViewModel
import com.example.bluzone.ui.screens.productDetails.ProductDetailsViewModel

@Composable
fun ProductCard(
    product: Product,
    productsViewModel: ProductDetailsViewModel,
    fromCart: Boolean = false,
    cartViewModel: CartViewModel,
    onCardClick: (String) -> Unit,
) {
    val products = productsViewModel.products.collectAsState()
    val productInDb = products.value.find { it.id == product.id }
    ProductCardContent(
        product = productInDb ?: product,
        quantityInCart = product.quantityInCart,
        onBuyClick = {
            cartViewModel.addToCart(product, 1)
        },
        onFavoriteClick = {
            productsViewModel.toggleFavorite(product)
        },
        cartViewModel = cartViewModel,
        fromCart = fromCart
    ){
        onCardClick(it)
    }
}