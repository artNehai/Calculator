package com.example.calculator

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorTheme(
    content: @Composable () -> Unit,
) {
    val fontProvider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs,
    )
    val robotoMonoFont = FontFamily(
        Font(
            googleFont = GoogleFont(
                name = "Dosis",
            ),
            fontProvider = fontProvider,
        ),
    )

    MaterialTheme(
        colorScheme =
        if (isSystemInDarkTheme()) {
            darkColorScheme().copy(
                primary = Color(0xff548964),
                primaryContainer = Color(0xff42A610),
                onPrimaryContainer = Color(0xffECFFDE),
                secondary = Color(0xff171717),
                onSecondary = Color(0xffF2F2F2),
                background = Color(0xff010101),
                onBackground = Color(0xffF2F2F2),
            )

        } else {
            lightColorScheme().copy(
                primary = Color(0xff548964),
                primaryContainer = Color(0xff42A610),
                onPrimaryContainer = Color(0xffECFFDE),
                secondary = Color(0xffEEEEF0),
                onSecondary = Color(0xff504F54),
                onBackground = Color(0xff504F54),
            )
        },
        typography = configureAppFont(
            fontFamily = robotoMonoFont,
            fontSize = 24.sp
        ),
        content = content,
    )
}

private fun configureAppFont(
    fontFamily: FontFamily,
    fontSize: TextUnit,
): Typography {
    val materialTypography = Typography()
    return Typography(
        displayLarge = materialTypography.displayLarge.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        displayMedium = materialTypography.displayMedium.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        displaySmall = materialTypography.displaySmall.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        headlineLarge = materialTypography.headlineLarge.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        headlineMedium = materialTypography.headlineMedium.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        headlineSmall = materialTypography.headlineSmall.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        titleLarge = materialTypography.titleLarge.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        titleMedium = materialTypography.titleMedium.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        titleSmall = materialTypography.titleSmall.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        bodyLarge = materialTypography.bodyLarge.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        bodyMedium = materialTypography.bodyMedium.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        bodySmall = materialTypography.bodySmall.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        labelLarge = materialTypography.labelLarge.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        labelMedium = materialTypography.labelMedium.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
        labelSmall = materialTypography.labelSmall.copy(
            fontFamily = fontFamily,
            fontSize = fontSize,
        ),
    )
}