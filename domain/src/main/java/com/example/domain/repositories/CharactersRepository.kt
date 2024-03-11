package com.example.domain.repositories

import com.example.core.base.BaseResponse
import com.example.domain.models.Character
import retrofit2.http.Path

interface CharactersRepository {
    suspend fun getCharacters(): BaseResponse<List<Character>>

    suspend fun getCharacter(
        @Path("id")
        id: Int
    ): Character
}