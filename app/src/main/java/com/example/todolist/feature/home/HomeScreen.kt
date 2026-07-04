package com.example.todolist.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import com.example.todolist.ui.components.TopBar
import com.example.todolist.ui.components.items.AddTaskItems
import com.example.todolist.ui.components.items.TaskBox
import com.example.todolist.ui.components.textfield.MenuTitleText
import com.example.todolist.ui.theme.AlterColor
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.ui.viewmodel.ThemeViewModel


@Composable
fun HomeScreen(
    themeViewModel: ThemeViewModel = hiltViewModel(),
    navController: NavController
) {
    val currentThemeColor by themeViewModel.theme.collectAsState()

    HomeContent(
        currentThemeColor = currentThemeColor,
        navController = navController
    )
}

@Composable
fun HomeContent(
    currentThemeColor: Color,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                color = currentThemeColor,
                titleText = "Menu Homepage"
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

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


                TaskBox(
                    color = currentThemeColor
                ) {
                    AddTaskItems(
                        modifier = Modifier,
                        currentThemeColor = currentThemeColor
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
            navController = rememberNavController()
        )
    }
}