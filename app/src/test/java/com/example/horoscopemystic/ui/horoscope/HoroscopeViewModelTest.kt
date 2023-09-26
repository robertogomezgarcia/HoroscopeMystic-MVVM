package com.example.horoscopemystic.ui.horoscope

import com.example.horoscopemystic.data.providers.HoroscopeProvider
import com.example.horoscopemystic.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest {
    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscopes are loaded`(){
//        Given
//        coEvery { horoscopeProvider.getHoroscopes() } returns listOf()  CON CORRUTINAS
        every {  horoscopeProvider.getHoroscopes() } returns horoscopeInfoList  // SIN CORRUTINAS
        viewModel = HoroscopeViewModel(horoscopeProvider)

//        When
        val horoscopes = viewModel.horoscope.value
//        Then
        assertTrue(horoscopes.isNotEmpty())
    }
}