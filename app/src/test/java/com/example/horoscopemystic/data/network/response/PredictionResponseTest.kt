package com.example.horoscopemystic.data.network.response

import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test
import com.example.horoscopemystic.motherobject.HoroscopeMotherObject.anyResponse

class PredictionResponseTest{
    @Test
    fun `toDomain should return a correct PredictionModel`(){
//        Given
//        val horoscopeResponse = anyResponse.copy(sign = "gemini")
        val horoscopeResponse = anyResponse.copy(sign = "gemini")

//        When
        val predictionModel = horoscopeResponse.toDomain()

//        Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe  horoscopeResponse.horoscope
    }
}