package com.example.soundsavvyapp.feature.data.remote

import android.content.Context
import com.example.soundsavvyapp.BuildConfig
import com.example.soundsavvyapp.feature.data.remote.model.Ranking
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.domain.repository.RankingRepository

class RankingRepositoryImpl(context: Context) : BaseRepository(context), RankingRepository {

    private val remote = RetrofitClient.getService(RankingService::class.java)


    override fun getRanking(
        type: String,
        period: String,
        limit: Int,
        listener: APIListener<Ranking>
    ) {
        executeCall(remote.findRaking(BuildConfig.VagalumeSecAPIKEY, type, period, limit), listener)
    }
}