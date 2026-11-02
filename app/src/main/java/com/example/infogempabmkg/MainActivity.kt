package com.example.infogempabmkg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.infogempabmkg.ui.navigation.GempaNavGraph
import com.example.infogempabmkg.ui.theme.InfoGempaBMKGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InfoGempaBMKGTheme {
                GempaNavGraph()
            }
        }
    }
}