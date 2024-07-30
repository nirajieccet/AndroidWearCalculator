package com.example.calculator.presentation

import CalculatorApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.calculator.presentation.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CalculatorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_DeviceDefault)
        setContent {
            CalculatorApp(viewModel)
        }
    }
}
