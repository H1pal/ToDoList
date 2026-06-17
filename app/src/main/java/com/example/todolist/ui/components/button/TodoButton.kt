package com.example.todolist.ui.components.button

import android.R.attr.button
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.MainColor

@Composable
fun TodoButton(
    modifier: Modifier = Modifier,
    text: String,
    width: Dp,
    height: Dp = 56.dp,
    backgroundColor: Color = MainColor,
    contentColor: Color = Color.White,
    onClicked: () -> Unit
) {
    Button(
        modifier = modifier
            .size(width = width, height = height),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        onClick = onClicked
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.W500
        )
    }
}