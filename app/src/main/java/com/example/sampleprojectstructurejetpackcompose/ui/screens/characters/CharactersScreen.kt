package com.example.sampleprojectstructurejetpackcompose.ui.screens.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.sampleprojectstructurejetpackcompose.ui.screens.characters.components.CharacterDetails
import com.example.sampleprojectstructurejetpackcompose.ui.shared.ScreenContent

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {

   // StatusBarColor(color = Color.Transparent, darkTheme = true)
    val state by viewModel.viewState.collectAsState()
    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(key1 = Unit) {
        viewModel.setEvent(CharacterContract.Event.FetchCharacters)
    }

    LaunchedEffect(key1 = viewModel) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is CharacterContract.SideEffects.ShowErrorMessage -> {
                    showErrorDialog = true
                    errorMessage = effect.errorMessage
                }
            }
        }
    }
    Scaffold() { paddingValues ->

        ScreenContent(
            isLoading = state.loading,
            isError = showErrorDialog,
            onDismissError = {
                showErrorDialog = false
            },
            onConfirmError = {
                showErrorDialog = false
            }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .background(color = Color.Black)
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.data.orEmpty()) { character ->
                        CharacterDetails(character = character)
                    }
                }

            }
        }
    }
}


@Preview
@Composable
fun SignUpScreenPrev() {
    CharactersScreen()
}