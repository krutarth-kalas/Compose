package com.example.composeapp.basicconcept.navigation

import android.app.Activity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun ThirdScreen(context: Activity, navController: NavHostController) {
    Text(text = "Third Screen")
}