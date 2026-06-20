package com.example.todolist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TodoDivider(
    modifier: Modifier,
    thickness: Dp = 0.5.dp
) {
    HorizontalDivider(
        modifier = modifier
            .background(Color(0xFFE0E5ED)),
        thickness = thickness
    )
}

@Preview
@Composable
fun PreviewTodoDivider() {
    TodoDivider(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White),
        thickness = 5.dp
    )
}