package com.example.todolist.ui.components.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todolist.ui.components.ThemeBox

@Composable
fun TaskBox(
    modifier: Modifier = Modifier,
    color: Color,
    content: @Composable BoxScope.() -> Unit
) {
    ThemeBox(
        modifier = Modifier,
        color = color,
        height = 148.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}