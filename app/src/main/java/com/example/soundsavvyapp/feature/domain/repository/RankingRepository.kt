package com.example.soundsavvyapp.feature.domain.repository

import com.example.soundsavvyapp.feature.data.remote.model.All
import com.example.soundsavvyapp.feature.data.remote.model.Ranking
import com.example.soundsavvyapp.feature.domain.APIListener
import kotlinx.coroutines.flow.Flow

interface RankingRepository {

    fun getRanking(
        type: String,
        period: String,
        limit: Int,
        listener: APIListener<Ranking>
    )

}