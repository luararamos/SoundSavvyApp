package com.example.soundsavvyapp.feature.domain

import com.example.soundsavvyapp.feature.data.remote.model.Ranking

interface RankingCase {
    interface Repository {
        fun findRaking(type: String, period: String, limit: Int, listener: APIListener<Ranking>)
    }

    interface ViewModel {
        fun findRanking( type: String, period: String, limit: Int)
    }

    interface View {
        fun showRanking()
    }
}