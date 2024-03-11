package com.example.data.datasource.remote.services

import com.example.core.base.BaseResponse
import com.example.core.constants.EndPoint
import com.example.data.datasource.remote.dtos.res.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path


interface CharacterService {
    @GET(EndPoint.CHARACTER)
    suspend fun getCharacters(): BaseResponse<List<CharacterDto>>

    @GET(EndPoint.CHARACTER + "/{id}")
    suspend fun getCharacter(
        @Path("id")
        id: Int
    ): CharacterDto

}