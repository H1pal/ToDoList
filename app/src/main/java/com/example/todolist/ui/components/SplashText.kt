package com.example.todolist.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashDescription(
) {
    Text(
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = 12.dp
            ),
        text = "Todyapp",
        fontSize = 26.sp,
        fontWeight = FontWeight.W700,
        textAlign = TextAlign.Center,
        color = Color.White
    )

    Text(
        modifier = Modifier,
        text = "The best to do list application for you",
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        textAlign = TextAlign.Center,
        color = Color.White
    )
}