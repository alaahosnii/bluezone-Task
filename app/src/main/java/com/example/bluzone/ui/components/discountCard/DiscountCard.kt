package com.example.bluzone.ui.components.discountCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiscountCard(
    productDiscount: Int,
) {
    Box(
        modifier = Modifier
            .width(90.dp)
            .height(40.dp)
            .background(
                color = Color.Red,
                shape = RoundedCornerShape(13.dp)
            )
            .padding(
                start = 20.dp,
                end = 20.dp,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "$productDiscount%",
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}