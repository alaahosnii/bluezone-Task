package com.example.bluzone.ui.screens.productDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bluzone.data.local.entity.Product
import com.example.bluzone.ui.components.fixedBuyButton.FixedBuyButton
import com.example.bluzone.ui.screens.cart.CartViewModel

@Composable
fun ProductTab(
    product: Product,
    productsViewModel: ProductDetailsViewModel,
    cartViewModel: CartViewModel,
    onProductClick: (String) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        ProductTabContent(
            cartViewModel = cartViewModel,
            productsViewModel = productsViewModel,
            product = product,
        ){
            onProductClick(it)
        }
        FixedBuyButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            product = product,
            cartViewModel = cartViewModel
        )
    }
}
