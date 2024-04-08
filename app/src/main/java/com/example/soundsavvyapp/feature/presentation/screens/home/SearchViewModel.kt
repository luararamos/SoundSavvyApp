package com.example.soundsavvyapp.feature.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.soundsavvyapp.feature.data.local.Favorite
import com.example.soundsavvyapp.feature.data.remote.model.Doc
import com.example.soundsavvyapp.feature.data.remote.model.SearchMusic
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.domain.repository.FavoriteRepository
import com.example.soundsavvyapp.feature.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private var teste :String = ""

    private val _searchMusic = mutableStateOf(HomeState<Doc>())
    val searchMusic: State<HomeState<Doc>> = _searchMusic

    fun searchMusic(search: String){
        searchRepository.searchMusic(search, object : APIListener<SearchMusic> {
            override fun onSuccess(response: SearchMusic) {
                _searchMusic.value = searchMusic.value.copy(
                    value = response.response.docs
                )
            }

            override fun onError(response: String) {
                _searchMusic.value = searchMusic.value.copy(
                    error = response
                )
            }

            override fun onLoading(stateLoading: Boolean) {
                _searchMusic.value = searchMusic.value.copy(
                    isLoading = stateLoading
                )
            }
        })
    }

    fun insertMusic(doc: Doc){
        val disposable  =favoriteRepository.insertFavorite(Favorite(music = doc.title, art = doc.band, photo = ""))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       teste = "ok"
            }, { error ->
                error.printStackTrace()

            })

        disposables.add(disposable)
    }
}