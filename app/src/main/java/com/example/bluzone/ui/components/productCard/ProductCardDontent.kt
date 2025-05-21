package com.example.bluzone.ui.components.productCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bluzone.R
import com.example.bluzone.data.models.Product

@Composable
fun ProductCardContent(
    product: Product,
    onFavoriteClick: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        shape = RoundedCornerShape(
            10.dp
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .height(155.dp),
                painter = painterResource(id = product.photo),
                contentDescription = null,
            )
            Text(
                text = product.name,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(top = 10.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Text(
                    text = "\u200E${product.beforeDiscount}00 KWD",
                    textAlign = TextAlign.Start,
                    textDecoration = TextDecoration.LineThrough,
                    style = TextStyle(
                        fontSize = 17.sp,
                        color = Color.Red,
                    ),
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,

                ) {
                Text(
                    text = "\u200E${product.price}00 KWD",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    ),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    modifier = Modifier
                        .height(25.dp)
                        .padding(end = 6.dp),
                    painter = painterResource(id = R.drawable.love_icon),
                    contentDescription = null,
                )
                Button(
                    modifier = Modifier
                        .weight(1f),
//                        .height(40.dp),
                    onClick = { onClick() },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFE7E00)
                    )
                ) {
                    Text(
                        text = "اشتر الآن",
                        color = Color.White,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }


            }
        }
    }
}