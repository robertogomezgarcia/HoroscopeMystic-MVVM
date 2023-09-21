package com.example.horoscopemystic.data.providers

import com.example.horoscopemystic.domain.model.HoroscopeInfo
import com.example.horoscopemystic.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){

    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Aquario,
            Cancer,
            Capricornio,
            Scorpio,
            Geminis,
            Libra,
            Leo,
            Piscis,
            Sagitario,
            Tauro,
            Virgo
        )
    }
}