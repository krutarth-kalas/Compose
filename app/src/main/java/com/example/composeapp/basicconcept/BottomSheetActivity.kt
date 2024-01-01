package com.example.composeapp.basicconcept

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.example.composeapp.ui.theme.ComposeAppTheme

class BottomSheetActivity : androidx.activity.ComponentActivity()
{
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                Surface {
                BottomSheetNavigator {
                    Navigator(screen = BottomSheetScreen)
                }
                }
            }
        }
    }

    object BottomSheetScreen : Screen{
        @Composable
        override fun Content()
        {
            val navigator = LocalBottomSheetNavigator.current
            Button(onClick = {
                navigator.show(SheetContent)
            })
            {
                Text(text = "Click here")
            }

        }

    }

    object SheetContent : Screen{
        @Composable
        override fun Content()
        {
            val navigator = LocalBottomSheetNavigator.current

            LazyColumn{
                item {
                    IconButton(onClick = {navigator.hide() })
                    {
                        Icon(Icons.Default.Close,"")
                    }
                }

               items(count = 10){
                   Text(text = "count $it")
               }

            }
        }

    }

}