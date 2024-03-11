package com.example.somachateapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.sampleprojectstructurejetpackcompose.ui.navigation.Screen
import com.example.sampleprojectstructurejetpackcompose.ui.screens.characterDetails.CharacterDetailsScreen
import com.example.sampleprojectstructurejetpackcompose.ui.screens.characters.CharactersScreen


@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Characters.route
    ) {

        composable(
            route = Screen.Characters.route
        ) {
            CharactersScreen(navController = navController)
        }


        composable(
            route = Screen.CharacterDetails.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType }
            )
        ) {
            CharacterDetailsScreen(
                characterId = it.arguments?.getInt("id"),
                navController = navController
            )
        }
    }

}