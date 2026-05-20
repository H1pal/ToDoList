package com.example.todolist.ui.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun HomeItems(
    modifier: Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    )
}