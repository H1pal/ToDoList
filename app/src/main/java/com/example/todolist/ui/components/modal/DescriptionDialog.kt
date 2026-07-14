package com.example.todolist.ui.components.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun DescriptionDialog(
    modifier: Modifier = Modifier,
    currentThemeColor: Color,
    onDismissRequest: () -> Unit,
    title: String,
    description: String,
    onDeleteTask: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .width(320.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        currentThemeColor,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(vertical = 24.dp, horizontal = 28.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                    ) {
                        Text(
                            text = title,
                            color = Color.White,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.W600
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "할 일 지우기",
                        tint = Color.White,
                        modifier = Modifier
                            .size(26.dp)
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                onDeleteTask()
                            }
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = description,
                    modifier = Modifier
                )
            }
        }
    }
}