package com.example.sampleprojectstructurejetpackcompose.ui.screens.characters

import com.example.core.base.BaseViewModel
import com.example.domain.errors.ExceptionHandler

import com.example.domain.useCases.character.CharactersUseCases
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val characterUseCase: CharactersUseCases
) : BaseViewModel<CharacterDetailsContract.Event, CharacterDetailsContract.State>() {
    override fun setInitialState(): CharacterDetailsContract.State {
        return CharacterDetailsContract.State(
            loading = false
        )
    }


    override fun handleEvents(event: CharacterDetailsContract.Event) {
        when (event) {
            is CharacterDetailsContract.Event.FetchCharacterDetails -> getCharacterById(id = event.id)

            else -> {}
        }
    }

    override fun handleCoroutineException(exception: Throwable) {
        setState { copy(loading = false) }
        val message = ExceptionHandler.resolveError(exception).exception.message
            ?: "An unknown error occurred"
        setEffect { CharacterDetailsContract.SideEffects.ShowErrorMessage(message) }
    }


    private fun getCharacterById(id:Int) {
        launchCoroutine(Dispatchers.IO) {
            setState { copy(loading = true) }
            characterUseCase.getCharacterUseCase(id).collectLatest { resource ->
                when (resource) {
                    is Resource.Error -> {
                        setState { copy(loading = false) }
                        setEffect {
                            CharacterDetailsContract.SideEffects.ShowErrorMessage(
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
