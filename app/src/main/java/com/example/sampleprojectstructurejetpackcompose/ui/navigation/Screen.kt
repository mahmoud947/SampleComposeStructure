package com.example.sampleprojectstructurejetpackcompose.ui.navigation

sealed class Screen(val route: String) {
    data object Characters : Screen(route = "characters")

    data object CharacterDetails : Screen(route = "Character_details/{id}") {
        fun passId(id: Int): String = "Character_details/$id"
    }
}