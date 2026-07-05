package com.example.todolist.ui.components.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.todolist.ui.theme.LightGray
import com.example.todolist.ui.theme.MainColor
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimerDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    currentThemeColor: Color,
    onConfirm: (hour: Int, minute: Int, isAm: Boolean) -> Unit
) {
    val currentTime = LocalDateTime.now()

    var hour by remember { mutableLongStateOf(currentTime.hour.toLong()) }
    var minute by remember { mutableLongStateOf(currentTime.minute.toLong()) }
    hour %= 12
    minute %= 60

    var isAm by remember { mutableStateOf(true) }

    val hourAndMinute = buildAnnotatedString {
        withLink(
            LinkAnnotation.Clickable(
                tag = "hour",
                linkInteractionListener = { _ ->
                    hour++
                }
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.Light
                )
            ) {
                append(text = "$hour".padStart(2, '0'))

            }
        }

        append(":")

        withLink(
            link = LinkAnnotation.Clickable(
                tag = "minute",
                linkInteractionListener =  { _ ->
                    minute++
                }
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.Light
                )
            ) {
                append(
                    text = "$minute".padStart(2, '0')
                )
            }
        }

    }

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .width(320.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        currentThemeColor,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(vertical = 24.dp, horizontal = 28.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hourAndMinute,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "AM",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isAm) {
                            Color.White
                        } else Color.White.copy(alpha = 0.5f),
                        modifier = Modifier
                            .clickable {
                                isAm = true
                            }
                    )

                    Text(
                        text = "PM",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isAm) {
                            Color.White.copy(alpha = 0.5f)
                        } else Color.White,
                        modifier = Modifier
                            .clickable {
                                isAm = false
                            }
                    )
                }
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 28.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(220.dp)
                        .background(
                            LightGray,
                            shape = CircleShape
                        )
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)
                    ) {
                        val clockHours = mapOf(
                            3 to Modifier.align(Alignment.CenterEnd),
                            6 to Modifier.align(Alignment.BottomCenter),
                            9 to Modifier.align(Alignment.CenterStart),
                            0 to Modifier.align(Alignment.TopCenter)
                        )

                        clockHours.forEach { (h, modifier) ->
                            Text(
                                text = "$h",
                                modifier = modifier
                                    .size(42.dp)
                                    .background(
                                        color = if (hour.toInt() == h) currentThemeColor else Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .clickable {
                                        hour = h.toLong()
                                    },
                                color = Color.Black,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                lineHeight = 16.sp
                            )
                        }
                    }
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {

                        }
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Language,
                        contentDescription = "Zone",
                        tint = currentThemeColor,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "ZONE",
                        color = currentThemeColor,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextButton(
                        onClick = onDismissRequest
                    ) {
                        Text(
                            "CANCEL",
                            color = currentThemeColor,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    TextButton(
                        onClick = {
                            onConfirm(
                                hour.toInt(),
                                minute.toInt(),
                                isAm
                            )
                        }
                    ) {
                        Text(
                            "OK",
                            color = currentThemeColor,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

        }
    }
}

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