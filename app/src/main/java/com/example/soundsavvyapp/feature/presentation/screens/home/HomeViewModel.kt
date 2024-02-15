package com.example.soundsavvyapp.feature.presentation.screens.home

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.data.remote.model.Ranking
import com.example.soundsavvyapp.feature.data.remote.RankingRepositoryImpl
import com.example.soundsavvyapp.feature.domain.RankingCase
import com.example.soundsavvyapp.feature.domain.repository.RankingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val rankingRepository: RankingRepository
) : ViewModel() {

    private val _ranking = MutableLiveData<Ranking>()
    val ranking: LiveData<Ranking> = _ranking

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state


    fun getRanking( type: String, period: String, limit: Int) {
        rankingRepository.getRanking(type, period, limit, object : APIListener<Ranking> {
            override fun onSuccess(response: Ranking) {
                _ranking.value = response
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


}