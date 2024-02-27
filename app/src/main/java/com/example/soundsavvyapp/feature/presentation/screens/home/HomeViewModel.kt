package com.example.soundsavvyapp.feature.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.soundsavvyapp.common.details
import com.example.soundsavvyapp.feature.data.remote.model.All
import com.example.soundsavvyapp.feature.data.remote.model.Doc
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.data.remote.model.RankingArt
import com.example.soundsavvyapp.feature.data.remote.model.RankingMusic
import com.example.soundsavvyapp.feature.data.remote.model.SearchMusic
import com.example.soundsavvyapp.feature.domain.repository.RankingRepository
import com.example.soundsavvyapp.feature.domain.repository.SearchRepository
import com.example.soundsavvyapp.feature.presentation.screens.home.components.model.MusicDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val rankingRepository: RankingRepository,
    private val searchRepository: SearchRepository
) : ViewModel() {


    private val _state = mutableStateOf(HomeState<All>())
    val state: State<HomeState<All>> = _state

    private val _stateMusic = mutableStateOf(HomeState<MusicDetails>())
    val stateMusic: State<HomeState<MusicDetails>> = _stateMusic

    private val _searchMusic = mutableStateOf(HomeState<Doc>())
    val searchMusic: State<HomeState<Doc>> = _searchMusic

    init {
        getRankingArt()
        getRankingMusic()
    }

    fun getRankingArt( ) {
        rankingRepository.getRankingArt(object : APIListener<RankingArt> {
            override fun onSuccess(response: RankingArt) {
                _state.value = state.value.copy(
                    value = response.art.week.all
                )
            }
            override fun onError(response: String) {
                _state.value = state.value.copy(
                    error = response
                )
            }
            override fun onLoading(stateLoading: Boolean) {
                _state.value = state.value.copy(
                    isLoading = stateLoading
                )
            }
        })
    }

    fun getRankingMusic( ) {
        rankingRepository.getRankingMusic(object : APIListener<RankingMusic> {
            override fun onSuccess(response: RankingMusic) {
                _stateMusic.value = stateMusic.value.copy(
                    value = response.mus.week.all.details()
                )

            }
            override fun onError(response: String) {
                _stateMusic.value = stateMusic.value.copy(
                    error = response
                )
            }

            override fun onLoading(stateLoading: Boolean) {
                _stateMusic.value = stateMusic.value.copy(
                    isLoading = stateLoading
                )
            }

        })
    }

    fun searchMusic(search: String){
        searchRepository.searchMusic(search, object :APIListener<SearchMusic>{
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
}