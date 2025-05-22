package com.example.bluzone.ui.components.fixedBuyButton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bluzone.data.local.entity.Product
import com.example.bluzone.ui.screens.cart.CartViewModel
import com.example.bluzone.ui.screens.productDetails.ProductDetailsViewModel

@Composable
fun FixedBuyButton(
    modifier: Modifier,
    product: Product,
    cartViewModel: CartViewModel,
){
    var quantity by remember { mutableStateOf(1) }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
            ,
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                        onClick = {
                            if (quantity > 1) {
                                quantity--
                            }
                        },
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE3E3E3)
                        ),
                        contentPadding = PaddingValues(0.dp) // <== this helps!
                    ) {
                        Text(
                            text = "-",
                            fontSize = 20.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }

                    Text(
                        text = quantity.toString(),
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Button(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                        onClick = {
                            quantity++
                        },
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE3E3E3)
                        ),
                        contentPadding = PaddingValues(0.dp) // <== this helps!
                    ) {
                        Text(
                            text = "+",
                            fontSize = 20.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }

                }
                Button(
                    modifier = Modifier
                        .padding(
                            start = 10.dp
                        )
                        .weight(2.5f)
                        .fillMaxHeight(),
                    onClick = {
                        cartViewModel.addToCart(
                            product = product,
                            quantity = quantity
                        )
                    },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFE7E00)
                    )
                ) {
                    Text(
                        text = "اشتر الآن",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}