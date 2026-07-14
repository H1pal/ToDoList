package com.example.todolist.ui.components.modal

import android.icu.util.Calendar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.isPm
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.ui.components.items.TimeDialogBasicItems
import com.example.todolist.ui.components.items.TimePickerItems
import com.example.todolist.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimerDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    currentThemeColor: Color,
    onConfirm: (hour: String, minute: String, isAm: Boolean) -> Unit,
) {

    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false
    )


    TimeDialogBasicItems(
        currentThemeColor = currentThemeColor,
        onDismissRequest = onDismissRequest,
        onConfirm = {
            val hour = timePickerState.hour.toString().padStart(2, '0')
            val minute = timePickerState.minute.toString().padStart(2, '0')
            val isAm = !timePickerState.isPm


            onConfirm(
                hour,
                minute,
                isAm
            )
        }
    ) {
        TimePickerItems(
            state = timePickerState,
            currentThemeColor = currentThemeColor,
            modifier = Modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewTimerDialog() {
    TimerDialog(
        currentThemeColor = MainColor,
        onDismissRequest = {

        },
        onConfirm = { h, m, isAm ->

        }
    )
}