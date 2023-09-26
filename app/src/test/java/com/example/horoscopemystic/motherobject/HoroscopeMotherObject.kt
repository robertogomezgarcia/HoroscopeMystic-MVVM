package com.example.horoscopemystic.motherobject

import com.example.horoscopemystic.data.network.response.PredictionResponse
import com.example.horoscopemystic.domain.model.HoroscopeInfo

object HoroscopeMotherObject {

    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList =   listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Aquario,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Capricornio,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Geminis,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Piscis,
        HoroscopeInfo.Sagitario,
        HoroscopeInfo.Tauro,
        HoroscopeInfo.Virgo
    )
}