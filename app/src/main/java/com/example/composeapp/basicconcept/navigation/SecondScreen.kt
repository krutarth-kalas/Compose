package com.example.composeapp.basicconcept.navigation

import android.app.Activity
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(context: Activity, navHostController: NavHostController, data: String?){
    Button(onClick = {
        navHostController.navigate(NavigationFactory.ThirdScreen.route){
            /*popUpTo(NavigationFactory.FirstScreen.route){
                inclusive = false
            }*/
            //launchSingleTop = true
        }
       /* val intent = Intent(context,AnotherActivity::class.java).apply {
            //putExtra()
        }
        context.startActivity(intent)*/
    }) {
        //Text(text = "GO TO ANOTHER ACTIVITY")
        Text(text = "$data")

    }
}