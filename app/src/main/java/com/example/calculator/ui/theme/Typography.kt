package com.example.calculator.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.calculator.R

private val FontProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs,
)

private val RobotoMonoFont = FontFamily(
    Font(
        googleFont = GoogleFont(
            name = "Roboto",
        ),
        fontProvider = FontProvider,
    ),
)

private val FontSize = 28.sp

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    displayMedium = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    displaySmall = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    headlineLarge = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    headlineMedium = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    headlineSmall = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    titleLarge = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    titleMedium = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    titleSmall = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    bodyLarge = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    bodyMedium = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    bodySmall = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    labelLarge = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
    labelSmall = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = FontSize,
    ),
)