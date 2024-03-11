package com.example.sampleprojectstructurejetpackcompose.di


import com.example.domain.repositories.CharactersRepository

import com.example.domain.useCases.character.CharacterUseCases
import com.example.domain.useCases.character.GetCharacterUseCase
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
    ): CharacterUseCases = CharacterUseCases(
        getCharacterUseCase = GetCharacterUseCase(charactersRepository = repository)
    )
}