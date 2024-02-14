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
import com.example.soundsavvyapp.feature.data.remote.RankingRepository
import com.example.soundsavvyapp.feature.data.remote.model.All
import com.example.soundsavvyapp.feature.domain.RankingCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class HomeViewModel (
    application: Application
) :  AndroidViewModel(application), RankingCase.ViewModel{
    private val rakingRepository = RankingRepository(application.applicationContext)

    private val _ranking = MutableLiveData<Ranking>()
    val ranking: LiveData<Ranking> = _ranking

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    override fun findRanking( type: String, period: String, limit: Int) {
        _loading.value = true
        rakingRepository.findRaking(type, period, limit, object : APIListener<Ranking> {

            override fun onSuccess(response: Ranking) {
                _ranking.value = response
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