package com.example.calculator

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
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
                bestEffort = true,
            ),
            fontProvider = fontProvider,
        ),
    )

    val materialTypography = Typography()
    val materialColorScheme = lightColorScheme()
    MaterialTheme(
        colorScheme = materialColorScheme.copy(
            primary = Color(0xff548964),
            background = Color.Black,
            onTertiaryContainer = Color.Yellow,
        ),
        typography = Typography(
            displayLarge = materialTypography.displayLarge.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            displayMedium = materialTypography.displayMedium.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            displaySmall = materialTypography.displaySmall.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            headlineLarge = materialTypography.headlineLarge.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            headlineMedium = materialTypography.headlineMedium.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            headlineSmall = materialTypography.headlineSmall.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            titleLarge = materialTypography.titleLarge.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            titleMedium = materialTypography.titleMedium.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            titleSmall = materialTypography.titleSmall.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            bodyLarge = materialTypography.bodyLarge.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            bodyMedium = materialTypography.bodyMedium.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            bodySmall = materialTypography.bodySmall.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            labelLarge = materialTypography.labelLarge.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            labelMedium = materialTypography.labelMedium.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
            labelSmall = materialTypography.labelSmall.copy(
                fontFamily = robotoMonoFont,
                fontSize = 24.sp,
            ),
        ),
        content = content,
    )
}