package com.example.todolist.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.R
import com.example.todolist.ui.components.SplashDescription
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.util.route.Home
import com.example.todolist.util.route.Splash
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController // = rememberNavController()
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor)
    ) { innerPadding ->

        LaunchedEffect(Unit) {
            delay(1000)

            navController.navigate(Home) {
                popUpTo(Splash) { inclusive = true }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(68.dp),
                    painter = painterResource(id = R.drawable.todolist_logo),
                    contentDescription = "ToDoList"
                )

                SplashDescription()

                Spacer(modifier = Modifier.height(92.dp))
            }
        }

    }
}

//@Preview
//@Composable
//private fun SplashScreenPreview() {
//    ToDoListTheme {
//        SplashScreen()
//    }
//}