package com.example.data.repositories

import com.example.core.base.BaseResponse
import com.example.core.util.toDomainModel
import com.example.data.datasource.remote.services.CharacterService
import com.example.data.mapper.toDomain
import com.example.domain.models.Character
import com.example.domain.repositories.CharactersRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val service: CharacterService
) : CharactersRepository {
    override suspend fun getCharacters(): BaseResponse<List<Character>> {
        return service.getCharacters().toDomainModel { charactersDto ->
            charactersDto?.map {
                it.toDomain()
            }
        }
    }

    override suspend fun getCharacter(id: Int): Character {
        return service.getCharacter(id = id).toDomain()
    }

}