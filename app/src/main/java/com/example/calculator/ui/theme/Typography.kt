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

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = 40.sp,
        lineHeight = 48.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    displaySmall = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    headlineLarge = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    headlineMedium = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    headlineSmall = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    titleLarge = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    titleMedium = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    titleSmall = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    bodyLarge = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    bodyMedium = TextStyle(
        fontFamily = RobotoMonoFont,
        fontSize = 28.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    labelLarge = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
    labelSmall = TextStyle(
        fontFamily = RobotoMonoFont,
    ),
)