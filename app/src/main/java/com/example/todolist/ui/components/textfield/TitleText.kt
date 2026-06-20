package com.example.todolist.ui.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    title: String = "Todyapp",
    subTitle: String = "The best to do list application for you",
    titleColor: Color = Color.White,
    subTitleColor: Color = Color.White,
    titleFontSize: TextUnit = 26.sp,
    subTitleSize: TextUnit = 14.sp,
    titleFontWeight: FontWeight = FontWeight.W700,
    subTitleFontWeight: FontWeight = FontWeight.W400,
    space: Dp,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space),
        horizontalAlignment = horizontalAlignment
    ) {
        Text(
            modifier = Modifier,
            text = title,
            fontSize = titleFontSize,
            fontWeight = titleFontWeight,
            textAlign = TextAlign.Center,
            color = titleColor
        )

        Text(
            modifier = Modifier,
            text = subTitle,
            fontSize = subTitleSize,
            fontWeight = subTitleFontWeight,
            textAlign = TextAlign.Center,
            color = subTitleColor
        )
    }

}


@Preview
@Composable
fun PreviewTitleText() {
    TitleText(
        modifier = Modifier,
        space = 12.dp
    )
}