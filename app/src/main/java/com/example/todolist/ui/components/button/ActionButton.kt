package com.example.todolist.ui.components.button

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.todolist.ui.theme.MainColor

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    width: Dp,
    height: Dp = 56.dp,
    backgroundColor: Color = MainColor,
    contentColor: Color = Color.White,
    onClicked: () -> Unit,
    content: @Composable () -> Unit = {}
) {
    Button(
        modifier = modifier
            .size(width = width, height = height),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        onClick = onClicked,
        shape = RoundedCornerShape(25)
    ) {

        content()
    }
}

@Preview
@Composable
fun PreviewTodoButton() {
    ActionButton(
        width = 100.dp,
        onClicked = {}
    )
}