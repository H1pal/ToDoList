package com.example.todolist.ui.components.modal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.HomeWork
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.components.TodoDivider
import com.example.todolist.ui.components.button.ModalActionButton
import com.example.todolist.ui.components.items.CalendarItems
import com.example.todolist.ui.theme.AlterColor
import com.example.todolist.ui.theme.MainColor
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.temporal.ChronoField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarModalSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onAddTime: () -> Unit,
    onSchedule: (LocalDate) -> Unit,
    currentThemeColor: Color
) {
    val sheetState = rememberModalBottomSheetState()

    val currentTime = LocalDateTime.now()
    val nextWeek = currentTime.plusWeeks(1)

    var currentMonth by remember { mutableStateOf(YearMonth.of(currentTime.year, currentTime.month)) }
    var selectedDate by remember { mutableStateOf(LocalDate.of(currentTime.year, currentTime.month, currentTime.dayOfMonth)) }

    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        },
        sheetState = sheetState,
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(24.dp, 45.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(26.dp)
            ) {

                val text = listOf(
                    DateOptions(
                        text = "Today",
                        date = "${currentTime.dayOfMonth} " + "${currentTime.month}".substring(0, 4) + " ${currentTime.year}",
                        icon = Icons.Default.WbSunny
                    ),
                    DateOptions(
                        text = "Tomorrow",
                        date = "${currentTime.plusDays(1).dayOfWeek}",
                        icon = Icons.Default.Cloud
                    ),
                    DateOptions(
                        text = "This weekend",
                        date = "${currentTime.with(ChronoField.DAY_OF_WEEK, 1).dayOfWeek}",
                        icon = Icons.Default.DirectionsCar
                    ),
                    DateOptions(
                        text = "Next weekend",
                        date = "${nextWeek.dayOfMonth} " + "${nextWeek.month}".substring(0, 4) + " ${nextWeek.year}",
                        icon = Icons.Default.HomeWork
                    )
                )

                text.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                
                            },
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = option.icon,
                                contentDescription = option.text,
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 12.dp)
                            )

                            Text(
                                text = option.text,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W400,
                                color = Color.Black
                            )
                        }

                        Text(
                            text = option.date,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = AlterColor
                        )
                    }
                }

            }

            TodoDivider(
                modifier = Modifier
                    .padding(vertical = 24.dp)
            )

            Box(
                modifier = Modifier
            ) {
                CalendarItems(
                    modifier = Modifier,
                    currentMonth = currentMonth,
                    selectedDate = selectedDate,
                    onPlus = {
                        currentMonth = currentMonth.plusMonths(1)
                    },
                    onMinus = {
                        currentMonth = currentMonth.minusMonths(1)
                    },
                    currentThemeColor = currentThemeColor,
                    onSelectDate = { date ->
                        selectedDate = date
                    }
                )
            }

            Row(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                ModalActionButton(
                    modifier = Modifier,
                    contentColor = currentThemeColor,
                    onClicked = onAddTime,
                    text = "Add Time",
                    imageVector = Icons.Default.Add
                )

                ModalActionButton(
                    modifier = Modifier,
                    imageVector = Icons.Default.Timer,
                    text = "Reschedule",
                    onClicked = {
                        onSchedule(selectedDate)
                    },
                    backgroundColor = currentThemeColor
                )
            }
        }

    }
}

data class DateOptions(
    val text: String,
    val date: String,
    val icon: ImageVector
)

@Preview
@Composable
fun PreviewCalendarModalSheet() {
    CalendarModalSheet(
        currentThemeColor = MainColor,
        onDismissRequest = {},
        onSchedule = {},
        onAddTime = {}
    )
}