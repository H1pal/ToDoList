package com.example.todolist.ui.components.textfield

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.AlterColor

@Composable
fun MenuTitleText(
    modifier: Modifier,
    title : String,
    subTitle: String,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally
) {
    TitleText(
        modifier = modifier.padding(bottom = 8.dp),
        title = title,
        subTitle = subTitle,
        titleColor = Color.Black,
        subTitleColor = AlterColor,
        titleFontSize = 24.sp,
        titleFontWeight = FontWeight.W600,
        space = 8.dp,
        horizontalAlignment = horizontalAlignment
    )
}