package com.example.bluzone.ui.screens.productDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import com.example.bluzone.ui.components.SliderDot.SliderDot
import com.example.bluzone.ui.components.discountCard.DiscountCard
import com.example.bluzone.ui.components.productCard.ProductCard

@Composable
fun ProductTabContent(
    product: Product,
) {
    val similarProducts = listOf<Product>(
        Product(
            id = "1",
            name = "جاكيت رجالي بقلنسوة وبطانة" +
                    "فليس دافئة للشتاء ",
            price = 28.00,
            description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                    "المادة: ألياف البوليستر (البوليستر)\n" +
                    "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                    "الطول: عادي\n" +
                    "طول الكم: كم طويل\n" +
                    "نوع الأكمام: أكمام راجلان",
            beforeDiscount = 28.000,
            discount = 60,
            rating = 3,
            brand = "عتيج",
            sku = "6974321040059",
            photo = R.drawable.product1
        ),
        Product(
            id = "2",
            name = "جاكيت رجالي بقلنسوة وبطانة" +
                    "فليس دافئة للشتاء ",
            price = 28.00,
            description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                    "المادة: ألياف البوليستر (البوليستر)\n" +
                    "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                    "الطول: عادي\n" +
                    "طول الكم: كم طويل\n" +
                    "نوع الأكمام: أكمام راجلان",
            beforeDiscount = 28.000,
            discount = 60,
            rating = 3,
            brand = "عتيج",
            sku = "6974321040059",
            photo = R.drawable.product2
        ),
        Product(
            id = "3",
            name = "جاكيت نسائي بقلنسوة وبطانة" +
                    "فليس دافئة للشتاء ",
            price = 28.00,
            description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                    "المادة: ألياف البوليستر (البوليستر)\n" +
                    "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                    "الطول: عادي\n" +
                    "طول الكم: كم طويل\n" +
                    "نوع الأكمام: أكمام راجلان",
            beforeDiscount = 28.000,
            discount = 60,
            rating = 3,
            brand = "عتيج",
            sku = "6974321040059",
            photo = R.drawable.product3
        ),
        Product(
            id = "4",
            name = "جاكيت نسائي بقلنسوة وبطانة" +
                    "فليس دافئة للشتاء ",
            price = 28.00,
            description = "جاكيت شتوي أنيق للرجال بغطاء قابل للفصل - دافئ، عملي ومتعدد الاستخدامات للأعمال أو الأنشطة الخارجية\n" +
                    "المادة: ألياف البوليستر (البوليستر)\n" +
                    "المكونات: 100% ألياف البوليستر (البوليستر)\n" +
                    "الطول: عادي\n" +
                    "طول الكم: كم طويل\n" +
                    "نوع الأكمام: أكمام راجلان",
            beforeDiscount = 28.000,
            discount = 60,
            rating = 3,
            brand = "عتيج",
            sku = "6974321040059",
            photo = R.drawable.product4
        ),
    )
    LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 30.dp,
                start = 20.dp,
                end = 20.dp,
                bottom = 80.dp
            ),
//        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item(
            span = { GridItemSpan(2) },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = product.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .width(250.dp)
                        .height(325.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 10.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.share_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp),
                    )
                    Image(
                        painter = painterResource(id = R.drawable.love_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp),
                    )
                }
                SliderDot(
                    currentPage = 0,
                    totalPages = 4,
                )
                Text(
                    modifier = Modifier.padding(
                        top = 20.dp
                    ),
                    text = product.name,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 20.dp
                        )
                ) {
                    Text(
                        text = "\u200E${product.beforeDiscount}00 KWD",
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.LineThrough,
                        style = TextStyle(
                            fontSize = 17.sp,
                            color = Color.Red,
                        ),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 5.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "\u200E${product.price}00 KWD",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                        ),
                    )
                    DiscountCard(
                        productDiscount = product.discount
                    )

                }
                HorizontalDivider(
                    modifier = Modifier.padding(
                        top = 20.dp
                    ),
                    color = Color(0xFFAEADAD),
                    thickness = 0.dp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 5.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "الماركة : ${product.brand}",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "المزيد",
                            modifier = Modifier
                                .padding(horizontal = 5.dp),
                            fontSize = 15.sp,
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Arrow",
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 5.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(
                                    horizontal = 2.dp
                                )
                                .height(20.dp)
                                .width(20.dp),
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(
                                    horizontal = 2.dp
                                )
                                .height(20.dp)
                                .width(20.dp),
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(
                                    horizontal = 2.dp
                                )
                                .height(20.dp)
                                .width(20.dp),
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(
                                    horizontal = 2.dp
                                )
                                .height(20.dp)
                                .width(20.dp),
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(
                                    horizontal = 2.dp
                                )
                                .height(20.dp)
                                .width(20.dp),
                        )
                        Text(
                            text = "${product.rating}",
                            textAlign = TextAlign.Center,
                            textDecoration = TextDecoration.Underline,
                            style = TextStyle(
                                fontSize = 15.sp,
                            ),
                        )
                        Text(
                            text = "تقييمات",
                            modifier = Modifier
                                .padding(horizontal = 5.dp),
                            textAlign = TextAlign.Center,
                            textDecoration = TextDecoration.Underline,
                            style = TextStyle(
                                fontSize = 15.sp,
                            ),
                        )
                    }
                    Text(
                        "\u200E${product.sku} : SKU",
                        modifier = Modifier
                            .padding(horizontal = 5.dp),
                    )
                }
                HorizontalDivider(
                    modifier = Modifier.padding(
                        top = 10.dp
                    ),
                    color = Color(0xFFAEADAD),
                    thickness = 0.dp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 5.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        "الوصــف",
                        modifier = Modifier
                            .padding(horizontal = 5.dp),
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Arrow",
                    )
                }
                Text(
                    text = product.description,
                    modifier = Modifier.padding(
                        top = 5.dp
                    ),
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        fontSize = 17.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                    ),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 10.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = Color(0xFFAEADAD),
                        thickness = 0.dp
                    )
                    Text(
                        modifier = Modifier.
                        weight(1f),
                        text = "عناصر مماثلة",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    HorizontalDivider(
                        modifier = Modifier.
                        weight(1f),
                        color = Color(0xFFAEADAD),
                        thickness = 0.dp
                    )
                }
            }

        }
        items(similarProducts.size) { index ->
            ProductCard(
                product = similarProducts[index],
            )
        }
    }
}