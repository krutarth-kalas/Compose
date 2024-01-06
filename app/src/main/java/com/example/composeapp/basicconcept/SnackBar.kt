package com.example.composeapp.basicconcept

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackBar(scaffoldState: ScaffoldState){

    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier.fillMaxSize().padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { scope.launch { scaffoldState.snackbarHostState.showSnackbar("He","Howfdf")  }  }) {
            Text(text = "Show SnackBar")
        }
    }
}