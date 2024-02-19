package com.example.soundsavvyapp.feature.domain.repository

import com.example.soundsavvyapp.feature.data.remote.model.RankingArt
import com.example.soundsavvyapp.feature.data.remote.model.RankingMusic
import com.example.soundsavvyapp.feature.domain.APIListener

interface RankingRepository {
    fun getRankingArt(listener: APIListener<RankingArt>)

    fun getRankingMusic(listener: APIListener<RankingMusic>)

}