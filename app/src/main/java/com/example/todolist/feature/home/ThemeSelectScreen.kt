package com.example.todolist.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.components.button.ColorThemeButton
import com.example.todolist.ui.components.button.TodoButton
import com.example.todolist.ui.theme.AlterColor
import com.example.todolist.ui.theme.FourthColor
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.theme.SecondColor
import com.example.todolist.ui.theme.ThirdColor
import com.example.todolist.ui.viewmodel.ThemeViewModel
import com.example.todolist.util.route.Choice
import com.example.todolist.util.route.Home


@Composable
fun ThemeSelectScreen(
    navController: NavController,
    themeViewModel: ThemeViewModel = hiltViewModel()
) {

    val currentTheme by themeViewModel.theme.collectAsState()

    val choiceStart: () -> Unit = {
        navController.navigate(Home) {
            popUpTo(Choice) { inclusive = true }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
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
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = AlterColor
                )
            }

            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                ColorThemeButton(
                    color = MainColor,
                    isSelected = (currentTheme == MainColor),
                    onClicked = { themeViewModel.setTheme("Aqua") }
                )

                ColorThemeButton(
                    color = SecondColor,
                    isSelected = (currentTheme == SecondColor),
                    onClicked = { themeViewModel.setTheme("Black") }
                )

                ColorThemeButton(
                    color = ThirdColor,
                    isSelected = (currentTheme == ThirdColor),
                    onClicked = { themeViewModel.setTheme("Red") }
                )

                ColorThemeButton(
                    color = FourthColor,
                    isSelected = (currentTheme == FourthColor),
                    onClicked = { themeViewModel.setTheme("Blue") }
                )
            }

            TodoButton(
                modifier = Modifier
                    .padding(47.dp)
                    .align(alignment = Alignment.BottomCenter),
                text = "Open Todyapp",
                width = 327.dp,
                onClicked = { choiceStart() }
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun ThemeChoiceScreenPreview() {
    ThemeSelectScreen(navController = rememberNavController())
}