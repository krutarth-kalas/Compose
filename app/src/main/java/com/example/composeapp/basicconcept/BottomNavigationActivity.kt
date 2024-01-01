package com.example.composeapp.basicconcept

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.core.app.ComponentActivity
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.composeapp.ui.theme.ComposeAppTheme

class BottomNavigationActivity : androidx.activity.ComponentActivity()
{
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                TabNavigator(tab = HomeTab) {
                    Scaffold(
                       bottomBar = {
                           BottomNavigation {
                               TabNavigationItems(tab = HomeTab)
                               TabNavigationItems(tab = ProfileTab)
                           }
                       }
                    ) {
                     CurrentTab()
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItems(tab: Tab){
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(selected = tabNavigator.current == tab, onClick = { tabNavigator.current = tab }, icon = { Icon(tab.options.icon!!, contentDescription = tab.options.title) })
}

object HomeTab : Tab{
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Home)
            return remember {
                TabOptions(
                    0u,title,icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "Home")
    }

}

object ProfileTab : Tab{
    override val options: TabOptions
        @Composable
        get() {
            val title = "Profile"
            val icon = rememberVectorPainter(Icons.Default.Person)
            return remember {
                TabOptions(
                    0u,title,icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "Profile")
    }

}