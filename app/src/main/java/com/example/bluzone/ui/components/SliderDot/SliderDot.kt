package com.example.bluzone.ui.components.SliderDot

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SliderDot(
    currentPage: Int,
    totalPages: Int,
) {
    val dots = List(totalPages) { it }

    Row(
        modifier = Modifier
            .padding(
                top = 20.dp
            )
    ) {
        dots.forEachIndexed { index, i ->
            Box(
                modifier = Modifier
                    .padding(
                        horizontal = 3.dp,
                        vertical = 2.dp,
                    )
                    .width(10.dp)
                    .height(10.dp)
                    .background(
                        color = if (currentPage == index) Color(0xFFFE7E00) else Color(0x4DFE7E00),
                        shape = RoundedCornerShape(50),
                    )


            )
        }
    }

}