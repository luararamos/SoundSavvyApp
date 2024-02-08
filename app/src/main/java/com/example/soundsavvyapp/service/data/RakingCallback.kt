package com.example.soundsavvyapp.service.data

import com.example.soundsavvyapp.service.model.Art
import com.example.soundsavvyapp.service.model.Ranking

interface RakingCallback {

    fun onSuccess(response: Ranking)
    fun onError(response: String)
    fun onComplete()
}