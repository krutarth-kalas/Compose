package com.example.composeapp.basicconcept

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composeapp.ui.theme.ComposeAppTheme

class RadioButtonActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                //RadioButtonUI()
                //CheckBoxUI()
                //DialogScreen()
                AltertDialogScreen()
            }
        }
    }
}