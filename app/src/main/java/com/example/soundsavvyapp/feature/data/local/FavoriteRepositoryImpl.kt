package com.example.soundsavvyapp.feature.data.local

import android.content.Context
import com.example.soundsavvyapp.feature.domain.repository.FavoriteRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(private val favoriteDao: FavoriteDao)  : FavoriteRepository {

    override fun insertFavorite(music: Favorite): Completable {
        return favoriteDao.insertMusic(music)
    }

    override fun getAllFavorite(): Single<List<Favorite>> {
        return favoriteDao.getAllUser()
    }
}