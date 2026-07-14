package com.example.todolist.feature.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.components.TopBar
import com.example.todolist.ui.components.button.ActionButton
import com.example.todolist.ui.components.button.ColorThemeButton
import com.example.todolist.ui.components.textfield.MenuTitleText
import com.example.todolist.ui.theme.FourthColor
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.theme.SecondColor
import com.example.todolist.ui.theme.ThirdColor
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.ui.viewmodel.ThemeViewModel
import com.example.todolist.util.route.Choice
import com.example.todolist.util.route.Home

@Composable
fun ThemeScreen(
    navController: NavController,
    themeViewModel: ThemeViewModel = hiltViewModel()
) {
    val currentTheme = themeViewModel.theme.collectAsState()

    ThemeContent(
        navController = navController,
        currentTheme = currentTheme.value,
        onSelected = {
            themeViewModel.setTheme(it)
        }
    )
}


@Composable
fun ThemeContent(
    navController: NavController,
    currentTheme: Color,
    onSelected: (String) -> Unit
) {
    var componentOffset by remember { mutableStateOf(Offset.Zero) }
    var componentSize by remember { mutableStateOf(IntSize.Zero) }

    val choiceStart: () -> Unit = {
        navController.navigate(Home) {
            popUpTo(Choice) { inclusive = true }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                titleText = "Choose Theme",
                color = currentTheme
            ) {}
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            MenuTitleText(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .align(alignment = Alignment.TopCenter),
                title = "Create to do list",
                subTitle = "Choose your to do list color theme:"
            )


            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                ColorThemeButton(
                    modifier = Modifier,
                    color = MainColor,
                    onClicked = { coord ->
                        onSelected("Aqua")
                        componentOffset = coord
                    }
                )

                ColorThemeButton(
                    modifier = Modifier,
                    color = SecondColor,
                    onClicked = { coord ->
                        onSelected("Black")
                        componentOffset = coord
                    }
                )

                ColorThemeButton(
                    modifier = Modifier,
                    color = ThirdColor,
                    onClicked = { coord ->
                        onSelected("Red")
                        componentOffset = coord
                    }
                )

                ColorThemeButton(
                    modifier = Modifier,
                    color = FourthColor,
                    onClicked = { coord ->
                        onSelected("Blue")
                        componentOffset = coord
                    }
                )
            }

            ActionButton(
                modifier = Modifier
                    .padding(bottom = 47.dp)
                    .align(alignment = Alignment.BottomCenter),
                width = 327.dp,
                onClicked = {
                    choiceStart()
                },
                backgroundColor = currentTheme
            ) {
                Text(
                    modifier = Modifier,
                    text = "Open Todyapp",
                    fontSize = 18.sp
                )
            }

        }

        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Check Mark",
            tint = currentTheme,
            modifier = Modifier
                .size(32.dp)
                .background(Color.White)
                .onGloballyPositioned { position ->
                    componentSize = position.size
                }
                .offset {
                    IntOffset(
                        x = componentOffset.x.toInt() - componentSize.width / 2,
                        y = componentOffset.y.toInt() - componentSize.height / 2
                    )
                }
        )


    }
}

@Preview(showBackground = false)
@Composable
private fun ThemeChoiceScreenPreview() {
    ToDoListTheme {
        ThemeContent(
            navController = rememberNavController(),
            currentTheme = ThirdColor,
            onSelected = {}
        )
    }

}