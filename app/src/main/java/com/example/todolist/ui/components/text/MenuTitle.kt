package com.example.todolist.ui.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.AlterColor

@Composable
fun MenuTitle(
    title : String,
    subTitle: String
) {
    BasicText(
        title = title,
        subTitle = subTitle,
        titleColor = Color.Black,
        subTitleColor = AlterColor,
        titleFontSize = 24.sp,
        titleFontWeight = FontWeight.W600
    )
}