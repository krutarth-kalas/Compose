package com.example.composeapp.basicconcept.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.composeapp.ui.theme.ComposeAppTheme

class AnotherActivity : androidx.activity.ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                Text(text = "NEw Activity")
            }
        }
    }
}