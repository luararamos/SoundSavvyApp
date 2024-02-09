package com.example.soundsavvyapp.feature.data.remote

import com.example.soundsavvyapp.feature.data.remote.model.Ranking
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RankingService {

    @POST("rank.php")
    @FormUrlEncoded
    fun findRaking(
        @Field("apikey") apiKey: String,
        @Field("type") type: String,
        @Field("period") period: String,
        @Field("limit") limit: Int,
    ): Call<Ranking>
}