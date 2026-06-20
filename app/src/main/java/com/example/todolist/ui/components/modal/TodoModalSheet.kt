package com.example.todolist.ui.components.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.MoveToInbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.feature.home.FocusedField
import com.example.todolist.ui.components.TodoDivider
import com.example.todolist.ui.components.textfield.TodoTextField
import com.example.todolist.ui.theme.Ghost
import com.example.todolist.ui.theme.MainColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoModalSheet(
    modifier: Modifier = Modifier,
    currentThemeColor: Color,
    title: TextFieldValue,
    description: TextFieldValue,
    currentFocusedField: FocusedField,
    onDismissRequest: () -> Unit,
    onUpload: () -> Unit,
    onTitleChange: (TextFieldValue) -> Unit,
    onDescriptionChange: (TextFieldValue) -> Unit,
    onFocusChanged: (FocusedField) -> Unit,

    ) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        },
        sheetState = sheetState,
        containerColor = Color.White,
        dragHandle = null
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(vertical = 10.dp, horizontal = 24.dp)
        ) {
            TodoTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            onFocusChanged(FocusedField.TITLE)
                        }
                    },
                value = title,
                onValueChange = {
                    onTitleChange(it)
                },
                hint = "eg : Meeting with client",
                cursorColor = currentThemeColor
            )

            TodoTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            onFocusChanged(FocusedField.DESCRIPTION)
                        }
                    },
                value = description,
                onValueChange = {
                    onDescriptionChange(it)
                },
                hint = "Description",
                cursorColor = currentThemeColor
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    val icons = listOf(
                        Icons.Default.MoveToInbox,
                        Icons.Default.CalendarMonth,
                        Icons.Default.AccessTime,
                        Icons.Default.Flag
                    )

                    icons.forEach { icon ->
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = Ghost,
                            modifier = Modifier
                                .size(22.dp)
                                .background(Color.White)
                                .clickable {
                                    when (icon) {
                                        Icons.Default.MoveToInbox -> {}
                                        Icons.Default.CalendarMonth -> {}
                                        Icons.Default.AccessTime -> {}
                                        Icons.Default.Flag -> {}
                                    }
                                }
                        )
                    }
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = null,
                    tint = currentThemeColor,
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.White)
                        .clickable {
                            onUpload()
                        }
                )

            }

            TodoDivider(
                modifier = Modifier
                    .padding(vertical = 14.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val emojis = listOf("😀", "🤑", "😇", "🥰", "🙌", "👋", "😰", "✌️")
                emojis.forEach { emoji ->
                    Text(text = emoji,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                when (currentFocusedField) {
                                    FocusedField.TITLE -> {
                                        onTitleChange(insertText(title, emoji))
                                    }
                                    FocusedField.DESCRIPTION -> {
                                        onDescriptionChange(insertText(description, emoji))
                                    }
                                    FocusedField.NONE -> {}
                                }
                            }
                    )
                }
            }

        }
    }
}

fun insertText(value: TextFieldValue, textToInsert: String) : TextFieldValue {
    val selectionStart = value.selection.min
    val selectionEnd = value.selection.max

    val beforeText = value.text.substring(0, selectionStart)
    val afterText = value.text.substring(selectionEnd)

    val newText = beforeText + textToInsert + afterText
    val newCursorPosition = selectionStart + textToInsert.length

    return value.copy(
        text = newText,
        selection = TextRange(newCursorPosition)
    )
}

@Composable
@Preview
fun PreviewToddModalSheet() {
    TodoModalSheet(
        currentThemeColor = MainColor,
        onDismissRequest = {},
        onUpload = {
        },
        onFocusChanged = {

        },
        onDescriptionChange = {},
        onTitleChange = {},
        title = TextFieldValue("123"),
        description = TextFieldValue(""),
        currentFocusedField = FocusedField.NONE,
    )
}