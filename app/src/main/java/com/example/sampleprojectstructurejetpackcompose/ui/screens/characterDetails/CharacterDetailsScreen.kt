package com.example.sampleprojectstructurejetpackcompose.ui.screens.characterDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.sampleprojectstructurejetpackcompose.ui.screens.characters.CharacterDetailsContract
import com.example.sampleprojectstructurejetpackcompose.ui.screens.characters.CharacterDetailsViewModel
import com.example.sampleprojectstructurejetpackcompose.ui.screens.characters.CharactersScreen
import com.example.sampleprojectstructurejetpackcompose.ui.screens.characters.CharactersViewModel

import com.example.sampleprojectstructurejetpackcompose.ui.shared.ScreenContent

@Composable
fun CharacterDetailsScreen(
    viewModel: CharacterDetailsViewModel = hiltViewModel(),
    navController: NavController = rememberNavController(),
    characterId: Int?
) {

    val state by viewModel.viewState.collectAsState()
    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(key1 = characterId) {
        viewModel.setEvent(
            CharacterDetailsContract.Event.FetchCharacterDetails(
                id = characterId ?: 1
            )
        )
    }

    LaunchedEffect(key1 = viewModel) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is CharacterDetailsContract.SideEffects.ShowErrorMessage -> {
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
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Name: ${state.data?.name}",
                        style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
                    )
                    Text(
                        text = "Status: ${state.data?.status}",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                    )
                    Text(
                        text = "Species: ${state.data?.species}",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = rememberImagePainter(state.data?.image),
                        contentDescription = "Character Image",
                        modifier = Modifier.size(200.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Episodes:",
                        style = MaterialTheme.typography.headlineLarge.copy(color = Color.White)
                    )

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