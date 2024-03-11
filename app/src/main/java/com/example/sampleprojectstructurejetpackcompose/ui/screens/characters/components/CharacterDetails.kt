package com.example.sampleprojectstructurejetpackcompose.ui.screens.characters.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.domain.models.Character

@Composable
fun CharacterDetails(character: Character) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Name: ${character.name}", style = MaterialTheme.typography.bodyLarge.copy(color = Color.White))
        Text(text = "Status: ${character.status}", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White))
        Text(text = "Species: ${character.species}", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White))

        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = rememberImagePainter(character.image),
            contentDescription = "Character Image",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Episodes:", style = MaterialTheme.typography.headlineLarge.copy(color = Color.White))
        LazyRow {
            items(character.episode.orEmpty()) { episode ->
                Text(text = episode.orEmpty(), style = MaterialTheme.typography.bodySmall.copy(color = Color.White))
            }
        }
    }
}