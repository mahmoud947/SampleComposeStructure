package com.example.sampleprojectstructurejetpackcompose.ui.screens.characters

import com.example.core.base.ViewEvent
import com.example.core.base.ViewSideEffect
import com.example.domain.models.Character
import com.example.core.base.ViewState

class CharacterDetailsContract {
    sealed class Event : ViewEvent {
        data class FetchCharacterDetails(val id:Int) : Event()
    }

    sealed class SideEffects : ViewSideEffect {
        data class ShowErrorMessage(val errorMessage: String) : SideEffects()
    }

    data class State(
        override val loading: Boolean,
        val data: Character? = null,
    ) : ViewState {}

}