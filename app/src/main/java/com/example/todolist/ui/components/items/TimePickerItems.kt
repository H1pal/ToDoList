package com.example.todolist.ui.components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.ui.theme.LightGray
import com.example.todolist.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerItems(
    modifier: Modifier = Modifier,
    currentThemeColor: Color,
    state: TimePickerState
) {

    Column {
        TimePicker(
            state = state,
            colors = TimePickerDefaults.colors(
                clockDialColor = LightGray,
                selectorColor = currentThemeColor,
                containerColor = currentThemeColor,
                periodSelectorBorderColor = Color.Transparent,
                clockDialSelectedContentColor = Color.White,
                clockDialUnselectedContentColor = Color.Black,
                periodSelectorSelectedContainerColor = Color.Transparent,
                periodSelectorUnselectedContainerColor = Color.Transparent,
                periodSelectorSelectedContentColor = Color.White,
                periodSelectorUnselectedContentColor = Color.White.copy(alpha = 0.5f),
                timeSelectorSelectedContainerColor = Color.Transparent,
                timeSelectorUnselectedContainerColor = Color.Transparent,
                timeSelectorSelectedContentColor = Color.White,
                timeSelectorUnselectedContentColor = Color.White.copy(alpha = 0.75f)
            ),
            modifier = modifier
                .scale(0.8f)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewTimePickerDialogItems() {
    TimePickerItems(
        currentThemeColor = MainColor,
        state = rememberTimePickerState()
    )
}