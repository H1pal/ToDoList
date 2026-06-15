package com.example.todolist.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.components.ColorThemeButton
import com.example.todolist.ui.theme.AlterColor
import com.example.todolist.ui.theme.FourthColor
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.theme.SecondColor
import com.example.todolist.ui.theme.ThirdColor
import com.example.todolist.util.route.Choice
import com.example.todolist.util.route.Home

@Composable
fun ThemeChoiceScreen(
    navController: NavController
) {


    val themeChoice : () -> Unit = {
        navController.navigate(Home) {
            popUpTo(Choice) { inclusive = true }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column (
                modifier = Modifier
                    .padding(top = 84.dp, bottom = 32.dp)
                    .align(alignment = Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Create to do list",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600
                )

                Text(
                    text = "Choose your to do list color theme:",
                    modifier = Modifier,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = AlterColor
                )
            }



            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                ColorThemeButton(
                    color = MainColor,
                    onClicked = {
                        themeChoice()
                    }
                )

                ColorThemeButton(
                    color = SecondColor,
                    onClicked = {
                        themeChoice()
                    }
                )

                ColorThemeButton(
                    color = ThirdColor,
                    onClicked = {
                        themeChoice()
                    }
                )

                ColorThemeButton(
                    color = FourthColor,
                    onClicked = {
                        themeChoice()

                    }
                )
            }
        }

    }
}

@Preview(showBackground = false)
@Composable
private fun ThemeChoiceScreenPreview(

) {
    ThemeChoiceScreen(
        navController = rememberNavController()
    )
}