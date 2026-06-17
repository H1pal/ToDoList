package com.example.todolist.util.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolist.feature.SplashScreen
import com.example.todolist.feature.home.HomeRoute
import com.example.todolist.feature.home.ThemeScreen

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
            HomeRoute(navController = navController)
        }

        composable<Choice> {
            ThemeScreen(navController = navController)
        }
    }
}