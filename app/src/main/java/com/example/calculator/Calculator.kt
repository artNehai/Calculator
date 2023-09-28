package com.example.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
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

        Display(Modifier.weight(1F))

        EraseButton(
            modifier = Modifier
                .align(Alignment.End)
        )

        Divider(Modifier.padding(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            NumberButton(
                text = "7",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                text = "8",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                text = "9",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                icon = ImageVector.vectorResource(R.drawable.division_sign),
                modifier = Modifier.weight(1F),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            NumberButton(
                text = "4",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                text = "5",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                text = "6",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                icon = ImageVector.vectorResource(R.drawable.multiplication_sign),
                modifier = Modifier.weight(1F),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            NumberButton(
                text = "1",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                text = "2",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                text = "3",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                icon = ImageVector.vectorResource(R.drawable.minus_sign),
                modifier = Modifier.weight(1F),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            NumberButton(
                text = "0",
                modifier = Modifier.weight(1F),
            )
            NumberButton(
                text = ".",
                modifier = Modifier.weight(1F),
            )
            OperatorButton(
                icon = ImageVector.vectorResource(R.drawable.plus_sign),
                modifier = Modifier.weight(1F),
            )
            EqualsButton(
                icon = ImageVector.vectorResource(R.drawable.equals_sign),
                modifier = Modifier.weight(1F),
            )
        }
    }
}

@Preview
@Composable
private fun IconButtonPreview() {
    CalculatorTheme {
        InputButton(
            modifier = Modifier,
        ) {
            Text("9")
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
    IconButton(
        onClick = { /*TODO*/ },
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Outlined.Backspace,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
        )
    }

}

@Composable
private fun EqualsButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    InputButton(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        contentPadding = OperatorButtonPaddingValues,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
        )
    }
}

@Composable
private fun OperatorButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    InputButton(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = DefaultInputButtonContainerColor,
            contentColor = MaterialTheme.colorScheme.primary,
        ),
        contentPadding = OperatorButtonPaddingValues,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
        )
    }
}

@Composable
private fun NumberButton(
    text: String,
    modifier: Modifier = Modifier,
) {
    InputButton(
        modifier = modifier,
    ) {
        Text(text)
    }
}

@Composable
private fun InputButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = DefaultInputButtonContainerColor,
        contentColor = MaterialTheme.colorScheme.onSecondary,
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable (RowScope.() -> Unit),
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .padding(all = 8.dp)
            .aspectRatio(1F),
        shape = CircleShape,
        colors = colors,
        contentPadding = contentPadding,
        content = content,
    )
}

private val DefaultInputButtonContainerColor: Color
    @Composable
    get() = MaterialTheme.colorScheme.secondary

private val OperatorButtonPaddingValues =
    PaddingValues(
        start = 20.dp,
        top = 8.dp,
        end = 20.dp,
        bottom = 8.dp,
    )

@Composable
@Preview(
    showBackground = true,
)
private fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}