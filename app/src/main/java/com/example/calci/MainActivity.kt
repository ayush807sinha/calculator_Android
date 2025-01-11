package com.example.calci

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.calci.ui.theme.CalciTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val calculatorViewModel=ViewModelProvider(this)[calculatorViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            CalciTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary){
                    calscreen(calculatorViewModel)
                }
            }
        }
    }
}


