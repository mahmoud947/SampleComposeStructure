package com.example.sampleprojectstructurejetpackcompose.ui.navigation

sealed class Screen(val route: String) {
    data object Characters : Screen(route = "characters")

    data object Chat : Screen(route = "chat/{id}/{name}") {
        fun passIdAndName(id: String, name: String): String = "chat/$id/$name"
    }
}