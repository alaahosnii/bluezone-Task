package com.example.bluzone.ui.screens.productDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.bluzone.data.models.Product
import com.example.bluzone.ui.components.ProdcutTabs.ProductTabs

@Composable
fun ProductDetailsScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val product = Product(
        id = "1",
        name = "جاكيت رجالي أنيق بقلنسوة\n" +
                "مبطن بالفليس",
        price = 25.0,
        description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                "المادة: ألياف البوليستر (البوليستر)\n" +
                "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                "الطول: عادي\n" +
                "طول الكم: كم طويل\n" +
                "نوع الأكمام: أكمام راجلان",
        beforeDiscount = 63.000,
        discount = 60,
        rating = 3,
        brand = "عتيج",
        sku = "6974321040059",
        photo = R.drawable.product_img
    )
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
                    Image(
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp),
                        painter = painterResource(id = R.drawable.cart_icon),

                        contentDescription = "Cart Icon",
                    )

                }
                ProductTabs(
                    selectedTabIndex = selectedTabIndex,
                ) {
                    // Handle tab selection
                    selectedTabIndex = it
                }
            }

        }
        ProductTab(
            product = product
        )
    }
}
