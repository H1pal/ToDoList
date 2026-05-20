package com.example.todolist.feature.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.todolist.ui.components.HomeItems
import com.example.todolist.ui.components.TopBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                titleText = "Menu Homepage"
            )
        }
    ) { innerpadding ->
        HomeItems(
            modifier = Modifier
                .padding(innerpadding),
            navController = navController
        )
    }
}