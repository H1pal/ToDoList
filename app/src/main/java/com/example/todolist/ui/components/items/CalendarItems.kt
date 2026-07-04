package com.example.todolist.ui.components.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.Ghost
import com.example.todolist.ui.theme.MainColor
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth

@Composable
fun CalendarItems(
    modifier: Modifier,
    currentTime: LocalDateTime
) {
    var currentMonth by remember { mutableStateOf(YearMonth.of(currentTime.year, currentTime.month)) }
    var selectedDate by remember { mutableStateOf(LocalDate.of(currentTime.year, currentTime.month, currentTime.dayOfMonth)) }

    val days = getCalendarDays(currentMonth)

    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { currentMonth = currentMonth.minusMonths(1) }) {
                Icon(Icons.Default.KeyboardArrowLeft, contentDescription = null, tint = Color.DarkGray)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${currentMonth.month} ${currentMonth.year}",
                    fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Color.DarkGray
                )
                Icon(Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.DarkGray)
            }
            IconButton(onClick = { currentMonth = currentMonth.plusMonths(1) }) {
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.DarkGray)
            }
        }

        val daysOfWeek = listOf("M", "T", "W", "T", "F", "S", "S")
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            daysOfWeek.forEach { day ->
                Text(day, modifier = Modifier.weight(1f), textAlign = TextAlign.Center, color = Color.DarkGray, fontSize = 14.sp)
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier.height(260.dp),
            userScrollEnabled = false
        ) {
            items(days) { date ->
                val isSelected = (date == selectedDate)
                val isCurrentMonth = (date.month == currentMonth.month)

                Box(
                    modifier = Modifier
                        .aspectRatio(1.2f)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isSelected) MainColor else Color.Transparent)
                        .clickable { selectedDate = date },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = date.dayOfMonth.toString(),
                        color = when {
                            isSelected -> Color.White
                            isCurrentMonth -> Color.Black
                            else -> Ghost
                        },
                        fontSize = 15.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

    }
}

fun getCalendarDays(yearMonth: YearMonth): List<LocalDate> {
    val days = mutableListOf<LocalDate>()
    val firstDayOfMonth = yearMonth.atDay(1)
    val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value
    val startDay = firstDayOfMonth.minusDays((firstDayOfWeek - 1).toLong())

    var current = startDay
    repeat(42) {
        days.add(current)
        current = current.plusDays(1)
    }
    return days
}

@Preview
@Composable
fun PreviewCalendarItems() {
    CalendarItems(
        modifier = Modifier,
        currentTime = LocalDateTime.now()
    )
}