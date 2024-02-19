package com.example.soundsavvyapp.feature.data.remote

import android.content.Context
import com.example.soundsavvyapp.feature.data.remote.model.RankingArt
import com.example.soundsavvyapp.feature.data.remote.model.RankingMusic
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.domain.repository.RankingRepository

class RankingRepositoryImpl(context: Context) : BaseRepository(context), RankingRepository {

    private val remote = RetrofitClient.getService(RankingService::class.java)
    override fun getRankingArt(
        listener: APIListener<RankingArt>
    ) {
        executeCall(remote.findRakingArt(), listener)
    }

    override fun getRankingMusic(listener: APIListener<RankingMusic>) {
        executeCall(remote.findRakingMusic(), listener)
    }
}