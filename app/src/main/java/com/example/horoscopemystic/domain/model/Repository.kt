package com.example.horoscopemystic.domain.model

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}