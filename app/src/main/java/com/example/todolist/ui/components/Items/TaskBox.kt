package com.example.todolist.ui.components.Items

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolist.ui.components.ThemeBox

@Composable
fun TaskBox(
    modifier: Modifier,
    color: Color,
    content: @Composable BoxScope.() -> Unit
) {
    ThemeBox(
        modifier = Modifier,
        color = color,
        height = 148.dp
    ) {
        content()
    }
}