package com.example.composeapp.basicconcept.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun FirstScreen(navHostController: NavHostController){
    Button(onClick = { /*navHostController.navigate(NavigationFactory.SecondScreen.route)*/
        navHostController.navigate(NavigationFactory.SecondScreen.createRoute("fhfhfh")) })
    {
        Text(text = "FIrst Screen Click")
    }
}