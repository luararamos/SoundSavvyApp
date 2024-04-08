package com.example.soundsavvyapp.feature.domain.repository

import com.example.soundsavvyapp.feature.data.local.Favorite
import io.reactivex.Completable
import io.reactivex.Single

interface FavoriteRepository {

    fun insertFavorite(music: Favorite): Completable

    fun getAllFavorite(): Single<List<Favorite>>
}