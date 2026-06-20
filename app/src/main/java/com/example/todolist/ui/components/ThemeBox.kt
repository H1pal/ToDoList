package com.example.todolist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ThemeBox(
    modifier: Modifier,
    color: Color,
    height: Dp = 104.dp,
    content: @Composable BoxScope.() -> Unit
) {


    Box(
        modifier = modifier
            .size(width = 327.dp, height = height)
            .shadow(8.dp,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(Color.White)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .background(color)
            )

            content()
        }
    }
}

@Preview
@Composable
fun PreviewThemeButton(
//    modifier: Modifier,
//    color: Color,
//    onClicked: (Offset) -> Unit
) {
    var position by remember { mutableStateOf(Offset.Zero) }

//    ThemeButton(
//    ) {
//
//        Row(
//            modifier = Modifier
//                .padding(16.dp, bottom = 18.dp)
//                .align(alignment = Alignment.BottomStart)
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(34.dp)
//                    .clip(RoundedCornerShape(100))
//                    .background(LightGray)
//            )
//
//            Column(
//                modifier = Modifier
//                    .padding(start = 16.dp)
//                    .align(alignment = Alignment.CenterVertically),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//
//                listOf(185.dp, 128.dp, 156.dp).forEach { width ->
//                    Box(
//                        modifier = Modifier
//                            .size(width = width, height = 5.dp)
//                            .clip(RoundedCornerShape(100))
//                            .background(LightGray)
//                    )
//                }
//            }
//        }
//
//    }
}