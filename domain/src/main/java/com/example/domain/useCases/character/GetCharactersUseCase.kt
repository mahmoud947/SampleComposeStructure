package com.example.domain.useCases.character

import com.example.core.base.BaseUseCase
import com.example.domain.errors.ExceptionHandler
import com.example.domain.models.Character
import com.example.domain.repositories.CharactersRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class GetCharactersUseCase constructor(
    private val charactersRepository: CharactersRepository
) : BaseUseCase<Nothing?, Flow<Resource<List<Character>?>>> {
    override fun invoke(input: Nothing?): Flow<Resource<List<Character>?>> {
        return flow {
            emit(Resource.Loading)
            val result = charactersRepository.getCharacters()
            emit(Resource.Success(result.results))
        }.catch {
            emit(ExceptionHandler.resolveError(it))
        }
    }
}

