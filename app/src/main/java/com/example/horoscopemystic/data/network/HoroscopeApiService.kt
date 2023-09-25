package com.example.horoscopemystic.data.network

import com.example.horoscopemystic.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") horoscope:String): PredictionResponse
}