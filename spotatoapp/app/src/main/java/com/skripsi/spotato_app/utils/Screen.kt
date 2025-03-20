package com.skripsi.spotato_app.utils

sealed class Screen(val routes: String) {
    data object Main: Screen("MainScreen")
    data object Home: Screen("HomeScreen")
}
