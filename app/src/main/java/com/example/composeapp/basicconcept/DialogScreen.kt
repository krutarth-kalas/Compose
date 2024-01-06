package com.example.composeapp.basicconcept

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

@Composable
fun DialogScreen()
{
    var isDialog by remember { mutableStateOf(false) }

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { isDialog = true }) {
            Text(text = "Click Here")
        }
    }

    if (isDialog)

        Dialog(onDismissRequest = { isDialog = false }) {
            CircularProgressIndicator()
        }

}

@Composable
fun AltertDialogScreen(){

    var isDialog by remember { mutableStateOf(false) }


    Column(
        modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { isDialog = true }) {
            Text(text = "Click Here to Show Alert Dialog")
        }


    if (isDialog){
        
        AlertDialog(onDismissRequest = {  },
            title = {
                Text(text = "Dialog")
            },
            text = {
                Text(text = "Dialog Information")

            },
            modifier = Modifier.fillMaxWidth(),
            buttons = {
                Button(onClick = {
                    isDialog = false
                }, modifier = Modifier.align(CenterHorizontally)) {
                    Text(text = "Ok")
                }
            }
        )
    }
}
}