package com.example.todolist.ui.components.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.todolist.ui.theme.MainColor
import com.example.todolist.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeDialogBasicItems(
    modifier: Modifier = Modifier,
    currentThemeColor: Color,
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Box(
            modifier = Modifier
                .size(327.dp, 440.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(
                    RoundedCornerShape(10.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(115.dp)
                    .background(color = currentThemeColor)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                content()

                Row(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            contentColor = currentThemeColor,
                            containerColor = Color.Transparent
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Language,
                            contentDescription = "search",
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 5.dp)
                        )

                        Text(
                            text = "Zone",
                            style = Typography.bodyLarge.copy(
                                fontWeight = FontWeight.W500
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        Text(
                            text = "CANCEL",
                            modifier = modifier
                                .clickable {
                                    onDismissRequest()
                                },
                            style = Typography.bodyLarge.copy(
                                fontWeight = FontWeight.W500
                            ),
                            color = currentThemeColor
                        )

                        Text(
                            text = "OK",
                            modifier = modifier
                                .clickable {
                                    onConfirm()
                                },
                            style = Typography.bodyLarge.copy(
                                fontWeight = FontWeight.W500
                            ),
                            color = currentThemeColor
                        )
                    }
                }
            }
        }
    }

//    AlertDialog(
//        onDismissRequest = onDismissRequest,
//        dismissButton = {
//            TextButton(
//                onClick = onDismissRequest
//            ) {
//                Text(
//                    text = "CANCEL",
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 16.sp,
//                    lineHeight = 20.sp
//                )
//            }
//        },
//        confirmButton = {
//            TextButton(
//                onClick = onConfirm
//            ) {
//                Text(
//                    text = "OK",
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 16.sp,
//                    lineHeight = 20.sp
//                )
//            }
//        },
//        text = {
//            content()
//        }
//    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewTimeDialogBasicItems() {
    TimeDialogBasicItems(
        currentThemeColor = MainColor,
        onDismissRequest = {},
        onConfirm = {}
    ) {
        TimePickerItems(
            currentThemeColor = MainColor,
            state = rememberTimePickerState()
        )
    }
}