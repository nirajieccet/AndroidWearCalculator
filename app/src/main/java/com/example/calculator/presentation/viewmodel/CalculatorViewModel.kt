package com.example.calculator.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel : ViewModel() {
    private val _displayText = MutableStateFlow("0")
    val displayText: StateFlow<String> = _displayText

    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operation: String = ""

    fun onButtonClick(buttonText: String) {
        when (buttonText) {
            in "0".."9", "." -> {
                if (_displayText.value == "0") {
                    _displayText.value = buttonText
                } else {
                    _displayText.value += buttonText
                }
            }
            in listOf("+", "-", "*", "/") -> {
                operand1 = _displayText.value.toDouble()
                operation = buttonText
                _displayText.value = "0"
            }
            "=" -> {
                operand2 = _displayText.value.toDouble()
                val result = when (operation) {
                    "+" -> operand1 + operand2
                    "-" -> operand1 - operand2
                    "*" -> operand1 * operand2
                    "/" -> operand1 / operand2
                    else -> 0.0
                }
                _displayText.value = result.toString()
            }
            "C" -> {
                _displayText.value = "0"
                operand1 = 0.0
                operand2 = 0.0
                operation = ""
            }
        }
    }
}