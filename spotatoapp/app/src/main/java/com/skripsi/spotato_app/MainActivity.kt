package com.skripsi.spotato_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.skripsi.spotato_app.ui.navigation.Navigation
import com.skripsi.spotato_app.ui.theme.SpotatoappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpotatoappTheme {
                Navigation()
            }
        }
    }
}