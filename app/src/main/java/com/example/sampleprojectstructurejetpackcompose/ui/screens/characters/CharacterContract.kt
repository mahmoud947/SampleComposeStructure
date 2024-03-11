package com.example.sampleprojectstructurejetpackcompose.ui.screens.characters

import com.example.core.base.ViewEvent
import com.example.core.base.ViewSideEffect
import com.example.domain.models.Character
import com.example.core.base.ViewState

class CharacterContract {
    sealed class Event : ViewEvent {
        data object FetchCharacters : Event()

    }

    sealed class SideEffects : ViewSideEffect {
        data class ToCharacterDetails(val characterId: Int) : SideEffects()
        data class ShowErrorMessage(val errorMessage: String) : SideEffects()

    }

    data class State(
        override val loading: Boolean,
        val data: List<Character>? = null,
    ) : ViewState {}

}