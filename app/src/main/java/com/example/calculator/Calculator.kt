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
import androidx.compose.foundation.layout.sizeIn
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

        Display(
            modifier = Modifier.weight(1F),
        )

        EraseButton(
            modifier = Modifier
                .align(Alignment.End)
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
                NumberButton(text = "7")
                NumberButton(text = "8")
                NumberButton(text = "9")
                OperatorButton(
                    imageVector = ImageVector.vectorResource(R.drawable.division_sign),
                )
            }

            NumpadRow {
                NumberButton(text = "4")
                NumberButton(text = "5")
                NumberButton(text = "6")
                OperatorButton(
                    imageVector = ImageVector.vectorResource(R.drawable.multiplication_sign),
                )
            }

            NumpadRow {
                NumberButton(text = "1")
                NumberButton(text = "2")
                NumberButton(text = "3")
                OperatorButton(
                    imageVector = ImageVector.vectorResource(R.drawable.minus_sign),
                )
            }

            NumpadRow {
                NumberButton(text = "0")
                NumberButton(text = ".")
                OperatorButton(
                    imageVector = ImageVector.vectorResource(R.drawable.plus_sign),
                )
                EqualsButton(
                    icon = ImageVector.vectorResource(R.drawable.equals_sign),
                )
            }
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
private fun NumpadRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) =
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        content = content,
    )

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
    modifier: Modifier = Modifier,
) {
    InputButton(
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
    content: @Composable () -> Unit,
) {
    val maxSize = 64.dp
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .sizeIn(
                maxWidth = maxSize,
                maxHeight = maxSize,
            )
            .aspectRatio(1f),
        colors = colors,
        contentPadding = PaddingValues(all = 16.dp),
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
        Calculator()
    }
}