package com.example.horoscopemystic.domain.model

import com.example.horoscopemystic.R

sealed class HoroscopeInfo(val img:Int, val name:Int ){
    object Aries:HoroscopeInfo(R.drawable.aries, R.string.aries)
    object Aquario:HoroscopeInfo(R.drawable.aquario, R.string.aquarius)
    object Cancer:HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    object Capricornio:HoroscopeInfo(R.drawable.capricornio, R.string.capricorn)
    object Scorpio:HoroscopeInfo(R.drawable.escorpio, R.string.scorpio)
    object Geminis:HoroscopeInfo(R.drawable.geminis, R.string.gemini)
    object Libra:HoroscopeInfo(R.drawable.libra, R.string.libra)
    object Leo:HoroscopeInfo(R.drawable.leo, R.string.leo)
    object Piscis:HoroscopeInfo(R.drawable.piscis, R.string.pisces)
    object Sagitario:HoroscopeInfo(R.drawable.sagitario, R.string.sagittarius)
    object Tauro:HoroscopeInfo(R.drawable.tauro, R.string.taurus)
    object Virgo:HoroscopeInfo(R.drawable.virgo, R.string.virgo)
}