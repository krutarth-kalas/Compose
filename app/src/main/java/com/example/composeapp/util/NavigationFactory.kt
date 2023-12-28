package com.example.composeapp.util

sealed class NavigationFactory(val route : String)
{
    object FirstScreen : NavigationFactory("first")
    object SecondScreen : NavigationFactory("second")

}
