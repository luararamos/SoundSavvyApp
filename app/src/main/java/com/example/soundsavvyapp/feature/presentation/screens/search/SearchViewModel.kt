package com.example.soundsavvyapp.feature.presentation.screens.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soundsavvyapp.feature.data.local.Favorite
import com.example.soundsavvyapp.feature.data.remote.model.Doc
import com.example.soundsavvyapp.feature.data.remote.model.SearchMusic
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.domain.repository.FavoriteRepository
import com.example.soundsavvyapp.feature.domain.repository.SearchRepository
import com.example.soundsavvyapp.feature.presentation.screens.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    private val _searchMusic = mutableStateOf(HomeState<Doc>())
    val searchMusic: State<HomeState<Doc>> = _searchMusic

    private val _favorites = MutableLiveData<Map<String, Boolean>>().apply { value = emptyMap() }
    val favorites: LiveData<Map<String, Boolean>> = _favorites

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
                _favorites.value = _favorites.value?.plus(doc.id to true)
            }, { error ->
                error.printStackTrace()
            })

    }


}