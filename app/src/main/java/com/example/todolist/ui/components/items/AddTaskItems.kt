package com.example.todolist.ui.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.feature.home.HomeModalsScreen
import com.example.todolist.ui.components.TodoDivider
import com.example.todolist.ui.theme.AlterColor
import com.example.todolist.ui.theme.MainColor

@Composable
fun AddTaskItems(
    modifier: Modifier,
    currentThemeColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.BottomCenter)
        ) {
            HomeModalsScreen(
                modifier = Modifier,
                currentThemeColor = currentThemeColor
            )

            TodoDivider(
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Add your task",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = AlterColor
                )

                Text(
                    text = "Today • Mon 20 Jul 2022",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = AlterColor
                )
            }
        }

    }

}

@Preview
@Composable
fun PreviewAddTaskItems() {
    AddTaskItems(
        modifier = Modifier,
        currentThemeColor = MainColor
    )
}