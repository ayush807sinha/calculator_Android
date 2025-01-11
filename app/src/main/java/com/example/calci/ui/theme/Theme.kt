package com.example.calci.ui.theme

import android.R.id.primary
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = black200,
    secondary = black500,
    background = black500,
    tertiary = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    secondary = darkwhite,
    background = black200,
    tertiary = Color.Black
)

@Composable
fun CalciTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors=if(darkTheme){
        DarkColorScheme
    }else{
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}