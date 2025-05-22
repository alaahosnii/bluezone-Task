package com.example.bluzone.ui.screens.cart

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bluzone.ui.components.productCard.ProductCard
import com.example.bluzone.ui.screens.productDetails.ProductDetailsViewModel

@Composable
fun CartScreen(
    cartViewModel: CartViewModel,
    productsViewModel: ProductDetailsViewModel,
    onBackClick: () -> Unit,
) {
    val productsInCart by cartViewModel.cartProducts.collectAsState()

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(16.dp),

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { onBackClick() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Text(text = "Cart",)
        }
        if (productsInCart.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Your cart is empty")
            }
        } else {
            LazyColumn {
                items(productsInCart) { product ->
                    ProductCard(
                        product = product,
                        productsViewModel = productsViewModel,
                        cartViewModel = cartViewModel,
                        fromCart = true,
                    ){

                    }
                }
            }
        }

    }
}
