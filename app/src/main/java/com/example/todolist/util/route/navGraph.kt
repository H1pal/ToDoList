package com.example.todolist.util.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolist.feature.home.HomeScreen
import com.example.todolist.feature.splash.SplashScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {

        composable<Splash> {
            SplashScreen(navController = navController)
        }

        composable<Home> {
            HomeScreen(navController = navController)
        }
    }
}