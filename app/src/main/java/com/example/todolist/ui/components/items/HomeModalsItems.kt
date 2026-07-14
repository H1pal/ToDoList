package com.example.todolist.ui.components.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todolist.ui.components.modal.CalendarModalSheet
import com.example.todolist.ui.components.modal.TimerDialog
import com.example.todolist.ui.components.modal.TodoModalSheet
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.viewmodel.TodoViewModel
import java.time.LocalDate

@Composable
fun HomeModalsItems(
    modifier: Modifier = Modifier,
    currentThemeColor: Color,
    todoViewModel: TodoViewModel = hiltViewModel()
) {
    HomeModalsContent(
        currentThemeColor = currentThemeColor,
        onCompleteInfo = { title, description ->
            todoViewModel.setTodoInfo(title = title, description = description)
        },
        onCompleteTime = { time ->
            todoViewModel.setTodoTime(time = time)
        },
        onSchedule = { date ->
            todoViewModel.setSchedule(date = date)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeModalsContent(
    modifier: Modifier = Modifier,
    currentThemeColor: Color,
    onCompleteInfo: (String, String) -> Unit,
    onCompleteTime: (String) -> Unit,
    onSchedule: (LocalDate) -> Unit
) {
    var currentFocusedField by remember { mutableStateOf(FocusedField.NONE) }

    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var hour: String
    var minute: String
    var noon: String
    var time by remember { mutableStateOf("") }

    var isTodoOpen by remember { mutableStateOf(false) }
    var isCalendarOpen by remember { mutableStateOf(false) }
    var isTimerOpen by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(bottom = 22.dp)
            .clickable {
                isTodoOpen = true
            }
    ) {
        Box(
            modifier = Modifier
                .size(23.dp)
                .background(
                    color = currentThemeColor,
                    shape = RoundedCornerShape(25)
                )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Button",
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
                    .align(alignment = Alignment.Center)
            )
        }

        Spacer(
            modifier = Modifier
                .width(12.dp)
        )

        Text(
            modifier = Modifier,
            text = "Tap plus to create a new task ",
            color = Color(0xFF333333),
            fontWeight = FontWeight.W500,
            fontSize = 16.sp
        )
    }

    if (isTodoOpen) {
        TodoModalSheet(
            modifier = Modifier,
            currentThemeColor = currentThemeColor,
            title = title,
            description = description,
            currentFocusedField = currentFocusedField,
            onUpload = {
                isTodoOpen = false
                isCalendarOpen = true
                onCompleteInfo(title.text, description.text)
            },
            onTitleChange = { text ->
                title = text
            },
            onDescriptionChange = { text ->
                description = text
            },
            onFocusChanged = { focusedField ->
                currentFocusedField = focusedField
            },
            onDismissRequest = {
                isTodoOpen = false
            }
        )
    }

    if (isCalendarOpen) {
        CalendarModalSheet(
            currentThemeColor = currentThemeColor,
            onDismissRequest = {
                isCalendarOpen = false
            },
            onAddTime = {
                isTimerOpen = true
            },
            onSchedule = { date ->
                title = TextFieldValue("")
                description = TextFieldValue("")
                onSchedule(date)
                isCalendarOpen = false
            }
        )
    }

    if (isTimerOpen) {
        TimerDialog(
            currentThemeColor = currentThemeColor,
            onDismissRequest = {
                isTimerOpen = false
            },
            onConfirm = { h, m, isAm ->
                hour = h
                minute = m
                noon = if (isAm) "AM" else "PM"
                time = "${hour}:${minute} $noon"
                isTimerOpen = false
                onCompleteTime(time)
            }
        )
    }
}

enum class FocusedField {
    TITLE, DESCRIPTION, NONE
}

@Preview
@Composable
fun PreviewHomeModalsContent() {
    HomeModalsContent(
        modifier = Modifier,
        currentThemeColor = MainColor,
        onCompleteInfo = { t, d ->

        },
        onCompleteTime = {},
        onSchedule = {}
    )
}