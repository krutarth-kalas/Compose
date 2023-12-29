package com.example.composeapp.basicconcept.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun StartNavigation(context: Activity){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavigationFactory.FirstScreen.route ){
        composable(NavigationFactory.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(NavigationFactory.SecondScreen.route){
            val data = it.arguments?.getString("data")
            SecondScreen(context,navController,data)
        }
        composable(NavigationFactory.ThirdScreen.route){
            ThirdScreen(context,navController)
        }
    }
}