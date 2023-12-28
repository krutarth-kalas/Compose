package com.example.composeapp.basicconcept.navigation

import android.app.Activity
import android.content.Intent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(context: Activity){
    Button(onClick = {
        val intent = Intent(context,AnotherActivity::class.java).apply {
            //putExtra()
        }
        context.startActivity(intent)
    }) {
        Text(text = "GO TO ANOTHER ACTIVITY")
        
    }
}