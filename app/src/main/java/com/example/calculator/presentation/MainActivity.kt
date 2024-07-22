package com.example.calculator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.calculator.presentation.widgets.CalculatorButtons
import kotlin.text.contains
import kotlin.text.toDouble

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_DeviceDefault)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {
    var displayText by remember { mutableStateOf("0") }
    var operand1 by remember { mutableDoubleStateOf(0.0) }
    var operand2 by remember { mutableDoubleStateOf(0.0) }
    var operation by remember { mutableStateOf("") }

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
                when (buttonText) {
                    in "0".."9", "." -> {
                        if (displayText == "0") {
                            displayText = buttonText
                        } else {
                            displayText += buttonText
                        }
                    }
                    in "+", "-", "*", "/" -> {
                        operand1 = displayText.toDouble()
                        operation = buttonText
                        displayText = "0"
                    }
                    "=" -> {
                        operand2 = displayText.toDouble()
                        val result = when (operation) {
                            "+" -> operand1 + operand2
                            "-" -> operand1 - operand2
                            "*" -> operand1 * operand2
                            "/" -> operand1 / operand2
                            else -> 0.0
                        }
                        displayText = result.toString()
                    }
                    "C" -> {
                        displayText = "0"
                        operand1 = 0.0
                        operand2 = 0.0
                        operation = ""
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true, device = "id:wear_os_large_round")
@Composable
fun CalculatorAppPreview() {
    MaterialTheme {
        CalculatorApp()
    }
}