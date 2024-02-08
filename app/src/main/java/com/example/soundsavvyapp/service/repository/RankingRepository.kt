package com.example.soundsavvyapp.service.repository

import android.content.Context
import com.example.soundsavvyapp.service.constants.SoundSavvyConstants
import com.example.soundsavvyapp.service.data.RakingCallback
import com.example.soundsavvyapp.service.model.Ranking
import com.example.soundsavvyapp.service.repository.remote.HTTPClient
import com.example.soundsavvyapp.service.repository.remote.RankingService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RankingRepository(val context: Context) {

    fun findRaking(
        type: String,
        period: String,
        limit: Int,
        listener: RakingCallback
    ) {
        HTTPClient.retrofit()
            .create(RankingService::class.java)
            .findRaking(SoundSavvyConstants.KEY.API_KEY,type, period,limit)
            .enqueue(object : Callback<Ranking> {
                override fun onResponse(call: Call<Ranking>, response: Response<Ranking>) {
                    if (response.isSuccessful) {
                        val ranking = response.body()
                        ranking?.let {
                            listener.onSuccess(ranking)
                        }
                    } else {
                        val error = response.errorBody()?.string()
                        listener.onError(error ?: SoundSavvyConstants.ERROR.UNKNOWN_ERROR)
                    }
                    listener.onComplete()
                }

                override fun onFailure(call: Call<Ranking>, t: Throwable) {
                    listener.onError(t.message ?: SoundSavvyConstants.ERROR.SERVICE_ERROR)
                    listener.onComplete()
                }


            })

    }
}