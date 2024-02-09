package com.example.soundsavvyapp.feature.data.remote

import android.content.Context
import com.example.soundsavvyapp.BuildConfig
import com.example.soundsavvyapp.feature.domain.APIListener
import com.example.soundsavvyapp.feature.data.remote.model.Ranking
import com.example.soundsavvyapp.feature.domain.RankingCase

class RankingRepository(context: Context): BaseRepository(context), RankingCase.Repository {

    private val remote = RetrofitClient.getService(RankingService::class.java)

    override fun findRaking(
        type: String,
        period: String,
        limit: Int,
        listener: APIListener<Ranking>
    ) {
        executeCall(remote.findRaking(BuildConfig.VagalumeSecAPIKEY,type, period,limit), listener)

    }
}