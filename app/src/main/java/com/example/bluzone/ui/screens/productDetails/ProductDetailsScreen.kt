package com.example.bluzone.ui.screens.productDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bluzone.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bluzone.data.local.entity.Product
import com.example.bluzone.ui.components.ProdcutTabs.ProductTabs
import com.example.bluzone.ui.screens.cart.CartViewModel
import com.example.bluzone.ui.screens.help.HelpScreen
import com.example.bluzone.ui.screens.review.ReviewScreen

@Composable
fun ProductDetailsScreen(
    productId: String,
    productsViewModel: ProductDetailsViewModel,
    cartViewModel: CartViewModel,
    onCartClick: () -> Unit,
    onProductClick: (String) -> Unit,
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val cartProducts by cartViewModel.cartProducts.collectAsState()
    val product = productsViewModel.dummyProducts.find {
        it.id == productId
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )
                )
                .border(
                    width = 1.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )
                )
                .shadow(
                    elevation = 1.dp,
                    ambientColor = Color.Transparent,
                    shape = RoundedCornerShape(
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )
                )

        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp),
                            onClick = { /* Handle back navigation */ },

                            ){
                            Icon(
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(30.dp),
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                contentDescription = "Back Icon",
                                tint = Color.Black
                            )
                        }
                        Text(
                            "ملابس / رجالي",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                    }

                        BadgedBox(
                            modifier = Modifier
                                .clickable {
                                    onCartClick()
                                },
                            badge = {
                                if (cartProducts.isNotEmpty()) {
                                    Badge(
                                        containerColor = Color.Red,
                                        contentColor = Color.White
                                    ) {
                                        Text(
                                            "${cartProducts.size}",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(30.dp),
                                painter = painterResource(id = R.drawable.cart_icon),
                                contentDescription = "Cart Icon",
                            )
                        }
                }
                ProductTabs(
                    selectedTabIndex = selectedTabIndex,
                ) {
                    // Handle tab selection
                    selectedTabIndex = it
                }
            }

        }
        when (selectedTabIndex) {
            0 -> ProductTab(
                product = product!!,
                productsViewModel = productsViewModel,
                cartViewModel = cartViewModel
            ){
                onProductClick(it)
            }
            1 -> ReviewScreen(
                productId = productId
            )
            2 -> HelpScreen(
                productId = productId
            )
        }
    }
}
