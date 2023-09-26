package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 12.dp),
    ) {
        MaterialTheme(
            colorScheme = lightColorScheme(background = Color.Green)
        ) {
            Display(
                modifier = Modifier
                    .weight(1F)
                    .background(MaterialTheme.colorScheme.background)
            )
        }

        EraseButton(
            modifier = Modifier
                .align(Alignment.End)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            NumberButton(
                "7",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                "8",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                "9",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                text = "÷",
                modifier = Modifier.weight(1F),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            NumberButton(
                "4",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                "5",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                "6",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                "×",
                modifier = Modifier.weight(1F),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            NumberButton(
                "1",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                "2",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                "3",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                "-",
                modifier = Modifier.weight(1F),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            NumberButton(
                "0",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                ".",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                "+",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                "=",
                modifier = Modifier.weight(1F),
            )
        }
    }
}

@Composable
private fun Display(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Text(
            text = "Display",
        )
    }
}

@Composable
private fun EraseButton(
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Outlined.Backspace,
            contentDescription = null,
        )
    }

}

@Composable
private fun OperatorButton(
    text: String,
    modifier: Modifier = Modifier,
) {
    InputButton(
        text = text,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = DefaultInputButtonContainerColor,
            contentColor = Color(0xff388709),
        ),
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun NumberButton(
    text: String,
    modifier: Modifier = Modifier,
) {
    InputButton(
        text = text,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = DefaultInputButtonContainerColor,
            contentColor = Color.Black,
        ),
    )
}

@Composable
private fun InputButton(
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(contentColor = Color.Black),
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .padding(all = 8.dp)
            .aspectRatio(1F),
        shape = CircleShape,
        colors = colors,
    ) {
        Text(
            text = text,
            fontWeight = fontWeight,
        )
    }
}

private val DefaultInputButtonContainerColor: Color
    @Composable
    get() = MaterialTheme.colorScheme.onTertiaryContainer

@Composable
@Preview(
    showBackground = true,
)
private fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}