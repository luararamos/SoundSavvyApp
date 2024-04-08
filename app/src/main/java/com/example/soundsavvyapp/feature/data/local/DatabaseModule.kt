package com.example.soundsavvyapp.feature.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "sound_savvy.db"
        ).build()
    }

    @Provides
    fun provideFavoriteDao(appDatabase: AppDatabase): FavoriteDao {
        return appDatabase.favoriteDao()
    }
}