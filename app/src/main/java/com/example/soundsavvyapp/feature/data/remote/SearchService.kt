package com.example.soundsavvyapp.feature.data.remote

import com.example.soundsavvyapp.feature.data.remote.model.SearchMusic
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SearchService {
    @GET("search.artmus")
    fun searchMusic(
        @Query("q") search: String,
        @Query("limit") limit: Int = 5,
    ): Call<SearchMusic>
}