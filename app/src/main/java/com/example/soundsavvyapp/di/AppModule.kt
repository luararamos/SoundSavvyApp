package com.example.soundsavvyapp.di

import android.app.Application
import com.example.soundsavvyapp.feature.data.remote.RankingRepositoryImpl
import com.example.soundsavvyapp.feature.data.remote.SearchRepositoryImpl
import com.example.soundsavvyapp.feature.domain.repository.RankingRepository
import com.example.soundsavvyapp.feature.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRepository(context: Application): RankingRepository {
        return RankingRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideRepositorySearch(context: Application): SearchRepository {
        return SearchRepositoryImpl(context)
    }


}