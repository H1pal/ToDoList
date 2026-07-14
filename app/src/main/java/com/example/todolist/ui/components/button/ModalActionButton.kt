package com.example.todolist.ui.components.button

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.LightGray

@Composable
fun ModalActionButton(
    modifier: Modifier,
    text: String,
    onClicked: () -> Unit,
    backgroundColor: Color = LightGray,
    contentColor: Color = Color.White,
    imageVector: ImageVector,
    contentDescription: String? = null
) {
    ActionButton(
        width = 155.dp,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        onClicked = onClicked
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription,
                modifier = Modifier
                    .size(24.dp)
            )

            Text(
                modifier = Modifier,
                text = text,
                fontSize = 14.sp
            )
        }
    }
}