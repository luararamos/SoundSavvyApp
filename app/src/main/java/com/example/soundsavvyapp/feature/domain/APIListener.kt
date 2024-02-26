package com.example.soundsavvyapp.feature.domain

interface APIListener <T> {
    fun onSuccess(response: T)
    fun onError(response: String)
    fun onLoading()
}