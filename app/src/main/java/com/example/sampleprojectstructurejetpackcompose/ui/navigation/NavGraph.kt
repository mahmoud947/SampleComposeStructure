package com.example.somachateapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sampleprojectstructurejetpackcompose.ui.navigation.Screen
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


//        composable(
//            route = Screen.Chat.route,
//            arguments = listOf(navArgument("id") {
//                type = NavType.StringType
//            },
//                navArgument("name"){
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            ChatScreen(receivedID = it.arguments?.getString("id").toString(),name = it.arguments?.getString("name").toString() )
//        }
    }

}