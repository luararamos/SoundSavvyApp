package com.example.soundsavvyapp.service.listener

interface APIListener <T> {
    fun onSuccess(response: T)
    fun onError(response: String)
    fun onComplete()
}