package com.example.composeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
               Scaffold (
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Compose")
                            },
                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Menu, contentDescription = "Menu")
                                }
                            },
                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Notifications, contentDescription = "Notification")
                                }
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Search, contentDescription = "Search")
                                }
                            }
                        )
                    },
                    //To add floating action button
                    floatingActionButton = {
                        FloatingActionButton(onClick = {  })
                        {
                            IconButton(onClick = {}) {
                                Icon(Icons.Filled.Add, contentDescription = "Add")
                            }
                        }
                    },
                    //floatingActionButtonPosition = FabPosition.End
                ) {
                    //Greeting("Welcome")
                   showSwitch()
                }

           /*  Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(70.dp),
        color = Color.Red
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        Greeting("ggfgggggggf")
    }
}

//TODO Switch Logic
@Composable
fun showSwitch(){

    //for storing the values if configuration chnages(to prevent data from loss) refer below function

    val isChecked  = remember {
        mutableStateOf(true)
    }

    Switch(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
        },
        /*colors  = SwitchDefaults.colors(
            checkedThumbColor = Blue,
            checkedTrackColor = Blue,
            uncheckedThumbColor = Yellow,
            uncheckedTrackColor= Yellow,
        ),*/
        modifier = Modifier.run {
            size(10.dp)
            padding(100.dp)
            //Modifier.background(if (isChecked.value) Blue else Yellow)
        },

    )
}
