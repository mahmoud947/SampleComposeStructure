package com.example.domain.repositories

import com.example.core.base.BaseResponse
import com.example.domain.models.Character

interface CharactersRepository {
    suspend fun getCharacters(): BaseResponse<List<Character>>
}