package com.skripsi.spotato_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skripsi.spotato_app.ui.screen.home.Home
import com.skripsi.spotato_app.ui.screen.main.Main
import com.skripsi.spotato_app.utils.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.routes
    ) {
        composable(route = Screen.Home.routes) { Home() }
    }
}