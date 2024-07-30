import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
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
    val configuration = LocalConfiguration.current
    val isRound = configuration.isScreenRound
    val screenWidth = configuration.screenWidthDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(if (isRound) 5.dp else 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(if (isRound) screenWidth * 0.5f else screenWidth * 0.8f)
                .background(Color.Gray)
                .padding(horizontal = 5.dp)
        ) {
            Text(
                text = displayText,
                color = Color.White,
                fontSize = if (isRound) 13.sp else 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = androidx.compose.ui.text.style.TextAlign.Right,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(if (isRound) 5.dp else 10.dp))

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