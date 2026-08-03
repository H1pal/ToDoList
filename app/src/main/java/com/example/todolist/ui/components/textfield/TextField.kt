package com.example.todolist.ui.components.textfield

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.Ghost

@Composable
fun TodoTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    hint: String,
    onValueChange: (TextFieldValue) -> Unit,
    cursorColor: Color,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                color = Ghost
            )
        },
        textStyle = LocalTextStyle.current.copy(
            fontSize = 18.sp
        ),
        modifier = Modifier,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = cursorColor
        ),
        maxLines = 5
    )
}