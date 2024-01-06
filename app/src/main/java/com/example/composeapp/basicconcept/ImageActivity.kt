package com.example.composeapp.basicconcept

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composeapp.ui.theme.ComposeAppTheme

class ImageActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                //PickImgFromGallery()
                PickImgFromCamera()
            }
        }
    }
}