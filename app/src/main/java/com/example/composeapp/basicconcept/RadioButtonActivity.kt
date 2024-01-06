package com.example.composeapp.basicconcept

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import com.example.composeapp.ui.theme.ComposeAppTheme

class RadioButtonActivity : ComponentActivity()
{
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                //RadioButtonUI()
                //CheckBoxUI()
                //DialogScreen()
                //AltertDialogScreen()

                //for snackbar only it required scaffold
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    scaffoldState = scaffoldState
                ) {
                    SnackBar(scaffoldState)
                }
            }
        }
    }
}