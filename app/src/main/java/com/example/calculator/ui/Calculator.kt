package com.example.calculator.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculator.Operator
import com.example.calculator.Operator.Add
import com.example.calculator.Operator.Divide
import com.example.calculator.Operator.Multiply
import com.example.calculator.Operator.Subtract
import com.example.calculator.R
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun Calculator(
    displayText: String,
    onEraseButtonClick: () -> Unit,
    onEraseButtonLongClick: () -> Unit,
    onNumberButtonClick: (String) -> Unit,
    onDecimalSeparatorClick: (String) -> Unit,
    onOperatorButtonClick: (Operator) -> Unit,
    onEqualsButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 12.dp),
    ) {

        Display(
            text = displayText,
            modifier = Modifier.weight(1F),
        )

        EraseButton(
            onClick = onEraseButtonClick,
            onLongClick = onEraseButtonLongClick,
            modifier = Modifier
                .align(Alignment.End),
        )

        Divider(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.1F),
        )

        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            NumpadRow {
                NumberButton(
                    text = "7",
                    onClick = { onNumberButtonClick("7") },
                )
                NumberButton(
                    text = "8",
                    onClick = { onNumberButtonClick("8") },
                )
                NumberButton(
                    text = "9",
                    onClick = { onNumberButtonClick("9") },
                )
                OperatorButton(
                    imageVector = ImageVector.vectorResource(R.drawable.division_sign),
                    onClick = { onOperatorButtonClick(Divide) },
                )
            }

            NumpadRow {
                NumberButton(
                    text = "4",
                    onClick = { onNumberButtonClick("4") },
                )
                NumberButton(
                    text = "5",
                    onClick = { onNumberButtonClick("5") },
                )
                NumberButton(
                    text = "6",
                    onClick = { onNumberButtonClick("6") },
                )
                OperatorButton(
                    imageVector = ImageVector.vectorResource(R.drawable.multiplication_sign),
                    onClick = { onOperatorButtonClick(Multiply) },
                )
            }

            NumpadRow {
                NumberButton(
                    text = "1",
                    onClick = { onNumberButtonClick("1") },
                )
                NumberButton(
                    text = "2",
                    onClick = { onNumberButtonClick("2") },
                )
                NumberButton(
                    text = "3",
                    onClick = { onNumberButtonClick("3") },
                )
                OperatorButton(
                    imageVector = ImageVector.vectorResource(R.drawable.subtraction_sign),
                    onClick = { onOperatorButtonClick(Subtract) },
                )
            }

            NumpadRow {
                NumberButton(
                    text = "0",
                    onClick = { onNumberButtonClick("0") },
                )
                NumberButton(
                    text = ".",
                    onClick = { onDecimalSeparatorClick(".") },
                )
                OperatorButton(
                    imageVector = ImageVector.vectorResource(R.drawable.addition_sign),
                    onClick = { onOperatorButtonClick(Add) },
                )
                EqualsButton(
                    icon = ImageVector.vectorResource(R.drawable.equality_sign),
                    onClick = onEqualsButtonClick,
                )
            }
        }
    }
}

@Composable
private fun Display(
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Text(
            text = text,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Composable
private fun NumpadRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) =
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        content = content,
    )

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun EraseButton(
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .clip(CircleShape)
            .combinedClickable(
                role = Role.Button,
                onClick = onClick,
                onLongClick = onLongClick,
            ),
        color = Color.Transparent,
    ) {
        Icon(
            imageVector = Icons.Outlined.Backspace,
            contentDescription = null,
            modifier = Modifier
                .size(44.dp)
                .padding(8.dp),
            tint = MaterialTheme.colorScheme.primary,
        )
    }

}

@Composable
private fun EqualsButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    InputButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
        )
    }
}

@Composable
private fun OperatorButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    InputButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = DefaultInputButtonContainerColor,
            contentColor = MaterialTheme.colorScheme.primary,
        ),
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
        )
    }
}

@Composable
private fun NumberButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    InputButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun InputButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = DefaultInputButtonContainerColor,
        contentColor = MaterialTheme.colorScheme.onSecondary,
    ),
    content: @Composable () -> Unit,
) {
    val maxSize = 68.dp
    Button(
        onClick = onClick,
        modifier = modifier
            .sizeIn(
                maxWidth = maxSize,
                maxHeight = maxSize,
            )
            .aspectRatio(1f),
        colors = colors,
        border = BorderStroke(width = Dp.Hairline, color = Color(0x4AEEEEF0)),
        contentPadding = PaddingValues(all = 8.dp),
    ) {
        content()
    }
}

private val DefaultInputButtonContainerColor: Color
    @Composable
    get() = MaterialTheme.colorScheme.secondary

@Composable
@Preview(
    showBackground = true,
)
private fun CalculatorPreview() {
    CalculatorTheme {
        Calculator(
            displayText = "43",
            onEraseButtonClick = {},
            onEraseButtonLongClick = {},
            onNumberButtonClick = {},
            onDecimalSeparatorClick = {},
            onOperatorButtonClick = {},
            onEqualsButtonClick = {},
        )
    }
}