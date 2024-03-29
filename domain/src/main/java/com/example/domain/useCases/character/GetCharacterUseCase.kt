package com.example.domain.useCases.character

import com.example.core.base.BaseUseCase
import com.example.domain.errors.ExceptionHandler
import com.example.domain.models.Character
import com.example.domain.repositories.CharactersRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GetCharacterUseCase constructor(
    private val charactersRepository: CharactersRepository
) : BaseUseCase<Int, Flow<Resource<Character?>>> {
    override fun invoke(input: Int): Flow<Resource<Character?>> {
        return flow {
            emit(Resource.Loading)
            val result = charactersRepository.getCharacter(id = input)
            emit(Resource.Success(result))
        }.catch {
            emit(ExceptionHandler.resolveError(it))
        }
    }
}

