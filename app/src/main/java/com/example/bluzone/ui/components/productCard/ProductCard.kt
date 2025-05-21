package com.example.bluzone.ui.components.productCard

import androidx.compose.runtime.Composable
import com.example.bluzone.data.models.Product

@Composable
fun ProductCard(
    product: Product
) {
    ProductCardContent(
        product = product,
        onClick = { /* TODO: Handle click */ },
        onFavoriteClick = {}
    )
}