package com.example.horoscopemystic.data

import android.util.Log
import com.example.horoscopemystic.data.network.HoroscopeApiService
import com.example.horoscopemystic.domain.model.PredictionModel
import com.example.horoscopemystic.domain.model.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Rober", "Ha ocurrido un error ${it.message}") }

        return null
    }
}