package com.example.horoscopemystic.data.network.response

import com.example.horoscopemystic.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(

    @SerializedName("date"      ) var date      : String,
    @SerializedName("horoscope" ) var horoscope : String,
    @SerializedName("sign"      ) var sign      : String

){

    fun toDomain(): PredictionModel{
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}
