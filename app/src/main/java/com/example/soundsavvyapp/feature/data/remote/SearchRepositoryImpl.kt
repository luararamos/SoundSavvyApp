package com.example.soundsavvyapp.feature.data.remote

import android.content.Context
import com.example.soundsavvyapp.feature.data.remote.model.SearchMusic
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.domain.repository.SearchRepository

class SearchRepositoryImpl(context: Context) : BaseRepository(context), SearchRepository{

    private val remote = RetrofitClient.getService(SearchService::class.java)

    override fun searchMusic(search: String, listener: APIListener<SearchMusic>) {
        executeCall(remote.searchMusic(search), listener)
    }
}