package com.example.soundsavvyapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.soundsavvyapp.service.data.RakingCallback
import com.example.soundsavvyapp.service.model.Art
import com.example.soundsavvyapp.service.model.Ranking
import com.example.soundsavvyapp.service.repository.RankingRepository

class RankingViewModel (application: Application) : AndroidViewModel(application){
    private val rakingRepository = RankingRepository(application.applicationContext)

    private val _ranking = MutableLiveData<Ranking>()
    val ranking: LiveData<Ranking> = _ranking

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    fun findRanking( type: String, period: String, limit: Int) {
        _loading.value = true
        rakingRepository.findRaking(type, period, limit, object :  RakingCallback {

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