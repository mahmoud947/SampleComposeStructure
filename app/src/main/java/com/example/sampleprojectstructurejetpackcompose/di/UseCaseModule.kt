package com.example.sampleprojectstructurejetpackcompose.di


import com.example.domain.repositories.CharactersRepository

import com.example.domain.useCases.character.CharactersUseCases
import com.example.domain.useCases.character.GetCharacterUseCase
import com.example.domain.useCases.character.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCharactersUseCase(
        repository: CharactersRepository
    ): CharactersUseCases = CharactersUseCases(
        getCharactersUseCase = GetCharactersUseCase(charactersRepository = repository),
        getCharacterUseCase = GetCharacterUseCase(charactersRepository = repository)
    )
}