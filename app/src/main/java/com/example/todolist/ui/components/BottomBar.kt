package com.example.todolist.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoveToInbox
import androidx.compose.material.icons.filled.Pages
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.todolist.ui.theme.AlterColor

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    currentThemeColor: Color
) {
    var selectedNavigator by remember { mutableStateOf(BottomBarNavigator.Home) }

    BottomAppBar(
        modifier = Modifier
            .shadow(10.dp),
        containerColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val bottomBarIcons = listOf(
                BottomBarIcon(Icons.Default.Home, BottomBarNavigator.Home),
                BottomBarIcon(Icons.Default.MoveToInbox, BottomBarNavigator.Move),
                BottomBarIcon(Icons.Default.CalendarMonth, BottomBarNavigator.Calendar),
                BottomBarIcon(Icons.Default.Category, BottomBarNavigator.Components),
                BottomBarIcon(Icons.Default.Pages, BottomBarNavigator.Etc)
            )

            bottomBarIcons.forEach { barIcon ->
                Box(
                    modifier = Modifier
                        .width(26.dp)
                        .fillMaxHeight()
                        .clickable {
                            selectedNavigator = barIcon.attribute
                        }
                ) {
                    Column(
                        modifier = Modifier
                    ) {
                        Divider(
                            modifier = Modifier
                                .padding(bottom = 10.dp),
                            thickness = 3.dp,
                            color = if (selectedNavigator == barIcon.attribute) currentThemeColor else Color.White
                        )

                        Icon(
                            imageVector = barIcon.icon,
                            contentDescription = "${barIcon.attribute}",
                            tint = if (selectedNavigator == barIcon.attribute) currentThemeColor else AlterColor,
                            modifier = Modifier
                                .aspectRatio(1f)
                        )

                    }
                }
            }
        }


    }

}

enum class BottomBarNavigator {
    Home, Move, Calendar, Components, Etc
}

data class BottomBarIcon(
    val icon: ImageVector,
    val attribute: BottomBarNavigator
)

