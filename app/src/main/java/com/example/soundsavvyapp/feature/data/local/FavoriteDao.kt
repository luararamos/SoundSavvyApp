package com.example.soundsavvyapp.feature.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface FavoriteDao {
    @Insert
    fun insertMusic(music: Favorite): Completable

    @Update
    fun updateMusic(music: Favorite): Completable

    @Query("SELECT * FROM Favorite")
    fun getAllUser(): Single<List<Favorite>>
}