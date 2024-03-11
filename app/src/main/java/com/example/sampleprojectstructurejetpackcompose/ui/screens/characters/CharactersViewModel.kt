package com.example.sampleprojectstructurejetpackcompose.ui.screens.characters

import com.example.core.base.BaseViewModel
import com.example.domain.errors.ExceptionHandler

import com.example.domain.useCases.character.CharacterUseCases
import com.example.domain.useCases.character.GetCharacterUseCase
import com.example.domain.utils.Resource
import com.example.sampleprojectstructurejetpackcompose.ui.screens.characters.CharacterContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCases
) : BaseViewModel<CharacterContract.Event, CharacterContract.State>() {
    override fun setInitialState(): CharacterContract.State {
        return CharacterContract.State(
            loading = false
        )
    }


    override fun handleEvents(event: CharacterContract.Event) {
        when (event) {
            CharacterContract.Event.FetchCharacters -> getCharacters()
        }
    }

    override fun handleCoroutineException(exception: Throwable) {
        setState { copy(loading = false) }
        val message = ExceptionHandler.resolveError(exception).exception.message
            ?: "An unknown error occurred"
        setEffect { CharacterContract.SideEffects.ShowErrorMessage(message) }
    }


    private fun getCharacters() {
        launchCoroutine(Dispatchers.IO) {
            setState { copy(loading = true) }
            characterUseCase.getCharacterUseCase(null).collectLatest { resource ->
                when (resource) {
                    is Resource.Error -> {
                        setState { copy(loading = false) }
                        setEffect {
                            CharacterContract.SideEffects.ShowErrorMessage(
                                resource.exception.message
                                    ?: "An unknown error occurred"
                            )
                        }
                    }

                    Resource.Idle -> {}
                    Resource.Loading -> setState { copy(loading = true) }
                    is Resource.Success -> {
                        setState { copy(loading = false, data = resource.data) }
                    }
                }
            }
        }
    }


}
