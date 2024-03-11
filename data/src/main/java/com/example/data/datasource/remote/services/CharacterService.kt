package com.example.data.datasource.remote.services

import com.example.core.base.BaseResponse
import com.example.core.constants.EndPoint
import com.example.data.datasource.remote.dtos.res.CharacterDto
import retrofit2.http.GET


interface CharacterService {

    @GET(EndPoint.CHARACTER)
    suspend fun getCharacters():BaseResponse<List<CharacterDto>>

}