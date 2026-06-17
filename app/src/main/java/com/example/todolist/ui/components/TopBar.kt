package com.example.todolist.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    titleText: String,
    color: Color = MainColor
) {
    TopAppBar(
        title = {
            Text(
                text = titleText,
                fontWeight = FontWeight.W500,
                fontSize = 22.sp
            )
        },
        colors = topAppBarColors(
            containerColor = color,
            titleContentColor = Color.White
        )
    )
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBar(
        titleText = "Hello World",
    )
}