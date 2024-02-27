package com.example.soundsavvyapp.feature.domain.repository

import com.example.soundsavvyapp.feature.data.remote.model.SearchMusic
import com.example.soundsavvyapp.feature.domain.APIListener

interface SearchRepository {
    fun searchMusic(search:String ,listener: APIListener<SearchMusic>)

}