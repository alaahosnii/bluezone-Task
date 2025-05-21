package com.example.bluzone.ui.screens.productDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bluzone.data.models.Product
import com.example.bluzone.ui.components.fixedBuyButton.FixedBuyButton

@Composable
fun ProductTab(
    product: Product
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        ProductTabContent(
            product = product,
        )
        FixedBuyButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
        )
    }
}
