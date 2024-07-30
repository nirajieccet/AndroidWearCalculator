package com.example.calculator.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.calculator.presentation.viewmodel.CalculatorViewModel
import com.example.calculator.presentation.widgets.CalculatorButtons

@Composable
fun CalculatorApp(viewModel: CalculatorViewModel) {
    val displayText by viewModel.displayText.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = displayText,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .background(Color.Gray)
                .padding(horizontal = 5.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Right
        )

        Spacer(modifier = Modifier.height(10.dp))

        CalculatorButtons(
            onButtonClick = { buttonText ->
                viewModel.onButtonClick(buttonText)
            }
        )
    }
}

@Preview(showBackground = true, device = "id:wear_os_large_round")
@Composable
fun CalculatorAppPreview() {
    MaterialTheme {
        val viewModel = CalculatorViewModel()
        CalculatorApp(viewModel)
    }
}
