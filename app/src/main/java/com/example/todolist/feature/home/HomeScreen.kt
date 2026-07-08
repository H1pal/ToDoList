package com.example.todolist.feature.home

import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.data.model.TodoTask
import com.example.todolist.ui.components.BottomBar
import com.example.todolist.ui.components.TodoDivider
import com.example.todolist.ui.components.TopBar
import com.example.todolist.ui.components.items.AddTaskItems
import com.example.todolist.ui.components.items.TaskBox
import com.example.todolist.ui.components.textfield.MenuTitleText
import com.example.todolist.ui.theme.AlterColor
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.ui.viewmodel.ThemeViewModel
import com.example.todolist.ui.viewmodel.TodoViewModel

@Composable
fun HomeScreen(
    themeViewModel: ThemeViewModel = hiltViewModel(),
    todoViewModel: TodoViewModel = hiltViewModel(),
    navController: NavController
) {
    val currentThemeColor by themeViewModel.theme.collectAsState()
    val todoList by todoViewModel.todoList.collectAsState()

    HomeContent(
        currentThemeColor = currentThemeColor,
        navController = navController,
        todoList = todoList,
        onClearAll = { todoViewModel.clearTask() }
    )
}

@Composable
fun HomeContent(
    currentThemeColor: Color,
    navController: NavController,
    todoList: List<TodoTask>,
    onClearAll: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar(
                color = currentThemeColor,
                titleText = "Menu Homepage"
            )
        },
        bottomBar = {
            BottomBar(
                currentThemeColor = currentThemeColor
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .align(alignment = Alignment.TopStart)
                        ) {
                            MenuTitleText(
                                modifier = Modifier,
                                title = "Today",
                                subTitle = "Best platform for creating to-do lists",
                                horizontalAlignment = Alignment.Start
                            )
                        }

                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Setting Icon",
                            tint = AlterColor,
                            modifier = Modifier
                                .padding(end = 24.dp)
                                .align(alignment = Alignment.CenterEnd)
                        )
                    }

                    TaskBox(color = currentThemeColor) {
                        AddTaskItems(
                            modifier = Modifier,
                            currentThemeColor = currentThemeColor
                        )
                    }
                }
            }

            items(
                items = todoList
            ) { task ->

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    TaskBox(
                        color = currentThemeColor,
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .align(alignment = Alignment.BottomCenter)
                            ) {
                                Text(
                                    text = task.title,
                                    color = Color.Black
                                )

                                if (task.description.isNotEmpty()) {
                                    Text(
                                        text = task.description,
                                        color = Color.Gray,
                                        modifier = Modifier
                                            .padding(top = 4.dp)
                                    )
                                }

                                TodoDivider(
                                    modifier = Modifier
                                        .padding(vertical = 8.dp)
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    if (!task.time.isNullOrEmpty()) {
                                        Text(
                                            text = task.time,
                                            color = Color.Gray
                                        )
                                    }

                                    if (task.date != null) {

                                        Text(
                                            text = "%3s %d %3s %d".format(
                                                task.date.month,
                                                task.date.dayOfMonth,
                                                task.date.dayOfWeek,
                                                task.date.year
                                            ),
                                            color = Color.Gray
                                        )
//
//                                        val dataText = runCatching {
//                                            "%s %d %s %d".format(
//                                                task.date.month,
//                                                task.date.dayOfMonth,
//                                                task.date.dayOfWeek,
//                                                task.date.year
//                                            )
//                                        }.getOrDefault("error")
                                    }

                                }
                            }

                        }



                    }
                }
            }

            item {
                TextButton(
                    onClick = onClearAll,
                    modifier = Modifier
                        .size(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "모든 데이터 삭제"
                    )
                }
            }
        }

    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    ToDoListTheme {
        HomeContent(
            currentThemeColor = MainColor,
            navController = rememberNavController(),
            todoList = emptyList(),
            onClearAll = {}
        )
    }
}