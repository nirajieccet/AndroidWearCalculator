package com.example.calculator.presentation.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text

@Composable
fun CalculatorButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(25.dp)
            .padding(2.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 10.sp,
            color = Color.White)
    }
}