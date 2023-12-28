package com.example.composeapp.basicconcept

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme


class StateManageActivity : ComponentActivity()
{
    private val viewModel:StateManageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                ShowWidget()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShowWidget(){
        //val name = remember { mutableStateOf("") }
        val name = rememberSaveable { mutableStateOf("") }
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           /*if (name.value.isNotEmpty()){
               Text(text = name.value, color = Color.Red)
           }*/

            //using view model
            if (viewModel.name.value.isNotEmpty()){
                Text(text = viewModel.name.value, color = Color.Red)
            }

            OutlinedTextField(
                value = name.value,
                onValueChange = {
                    name.value = it
                } ,
                label = {
                    Text(text = "Name")
                }
            )
        }
    }
}