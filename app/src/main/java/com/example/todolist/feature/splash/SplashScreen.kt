package com.example.todolist.feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.todolist.ui.components.SplashTextbox
import com.example.todolist.ui.theme.MainColor

@Composable
fun SplashScreen(
    navController: NavController
)
{
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MainColor)
    ) { innerPadding ->
        SplashTextbox(
            modifier = Modifier.padding(innerPadding)
        )
    }
}