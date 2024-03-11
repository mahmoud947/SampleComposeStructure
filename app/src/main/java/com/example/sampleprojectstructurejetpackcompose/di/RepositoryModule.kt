package com.example.sampleprojectstructurejetpackcompose.di



import com.example.data.datasource.remote.services.CharacterService
import com.example.data.repositories.CharacterRepositoryImpl
import com.example.domain.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRepository(service: CharacterService): CharactersRepository =
         CharacterRepositoryImpl(service = service)

}