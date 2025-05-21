package com.example.bluzone.ui.components.ProdcutTabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf("المنتج", "التقييم", "مساعدة")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp , vertical = 16.dp)
            .background(
                color = Color(0xFFF8F8F8),
                shape = RoundedCornerShape(40.dp)
            )
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { index, title ->
            Text(
                text = title,
                modifier = Modifier
                    .clickable { onTabSelected(index) }
                    .padding(horizontal = 12.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (index == selectedTabIndex) Color(0xFFFF8000) else Color.Black,
                    textAlign = TextAlign.Center
                )
            )
            if (index < tabs.size - 1) {
                VerticalDivider(
                    modifier = Modifier
                        .height(30.dp),
                    color = Color(0xFFE0E0E0),
                    thickness = 1.dp
                )
            }
        }
    }
}