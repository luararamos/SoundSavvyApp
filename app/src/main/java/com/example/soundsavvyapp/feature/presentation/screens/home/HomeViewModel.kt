package com.example.soundsavvyapp.feature.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soundsavvyapp.common.toDomain
import com.example.soundsavvyapp.feature.data.remote.model.All
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.data.remote.model.RankingArt
import com.example.soundsavvyapp.feature.data.remote.model.RankingMusic
import com.example.soundsavvyapp.feature.domain.repository.RankingRepository
import com.example.soundsavvyapp.feature.presentation.screens.home.components.model.MusicDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val rankingRepository: RankingRepository
) : ViewModel() {

    private val _rankingArt = MutableLiveData<RankingArt>()
    val rankingArt: LiveData<RankingArt> = _rankingArt

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _state = mutableStateOf(HomeState<All>())
    val state: State<HomeState<All>> = _state

    private val _stateMusic = mutableStateOf(HomeState<MusicDetails>())
    val stateMusic: State<HomeState<MusicDetails>> = _stateMusic

    fun getRankingArt( ) {
        rankingRepository.getRankingArt(object : APIListener<RankingArt> {
            override fun onSuccess(response: RankingArt) {
                _rankingArt.value = response
                _state.value = state.value.copy(
                    ranking = response.art.week.all
                )
            }
            override fun onError(response: String) {
                _error.value = response
            }

            override fun onComplete() {
                _loading.value = false
            }
        })
    }

    fun getRankingMusic( ) {
        rankingRepository.getRankingMusic(object : APIListener<RankingMusic> {
            override fun onSuccess(response: RankingMusic) {
                _stateMusic.value = stateMusic.value.copy(
                    ranking = response.mus.week.all.toDomain()
                )

            }
            override fun onError(response: String) {

            }

            override fun onComplete() {
            }
        })
    }
}