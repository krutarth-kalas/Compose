package com.example.composeapp.basicconcept.navigation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.app.ComponentActivity
import com.example.composeapp.ui.theme.ComposeAppTheme

class NavigationActivity : androidx.activity.ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                StartNavigation(this)
            }
        }
    }

}