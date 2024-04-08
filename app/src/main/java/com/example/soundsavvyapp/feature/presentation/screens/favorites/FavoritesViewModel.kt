package com.example.soundsavvyapp.feature.presentation.screens.favorites

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soundsavvyapp.feature.data.local.Favorite
import com.example.soundsavvyapp.feature.domain.repository.FavoriteRepository
import com.example.soundsavvyapp.feature.domain.repository.RankingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel@Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    val favoritesLiveData = MutableLiveData<List<Favorite>>()

    init {
        returnAllFavorites()
    }

    @SuppressLint("CheckResult")
    fun returnAllFavorites(){
        favoriteRepository.getAllFavorite()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ favorites ->
                favoritesLiveData.value = favorites
            }, { error ->
                error.printStackTrace()
            })

    }
}