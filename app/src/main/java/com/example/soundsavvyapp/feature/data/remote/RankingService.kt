package com.example.soundsavvyapp.feature.data.remote

import com.example.soundsavvyapp.BuildConfig
import com.example.soundsavvyapp.feature.data.remote.model.RankingArt
import com.example.soundsavvyapp.feature.data.remote.model.RankingMusic
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RankingService {

    @POST("rank.php")
    @FormUrlEncoded
    fun findRakingArt(
        @Field("type") type: String = "art",
        @Field("period") period: String = "week",
        @Field("limit") limit: Int = 10,
    ): Call<RankingArt>

    @POST("rank.php")
    @FormUrlEncoded
    fun findRakingMusic(
        @Field("type") type: String = "mus",
        @Field("period") period: String = "week",
        @Field("limit") limit: Int = 10,
    ): Call<RankingMusic>

}
