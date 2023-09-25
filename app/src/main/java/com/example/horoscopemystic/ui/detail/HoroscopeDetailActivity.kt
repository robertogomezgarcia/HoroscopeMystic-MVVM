package com.example.horoscopemystic.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopemystic.R
import com.example.horoscopemystic.databinding.ActivityHoroscopeDetailBinding
import com.example.horoscopemystic.domain.model.HoroscopeModel
import com.example.horoscopemystic.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()
    private val arg: HoroscopeDetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        horoscopeDetailViewModel.getHoroscope(arg.type)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener{ onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.progressBar.isVisible = false
        binding.tvTittle.text = state.sign
        binding.tvBody.text = state.prediction

        val image = when(state.horoscopeModel){
            Aries -> R.drawable.detail_aries
            Aquarius -> R.drawable.detail_aquarius
            Cancer -> R.drawable.detail_cancer
            Capricorn -> R.drawable.detail_capricorn
            Scorpio -> R.drawable.detail_scorpio
            Gemini -> R.drawable.detail_gemini
            Libra -> R.drawable.detail_libra
            Leo -> R.drawable.detail_leo
            Pisces -> R.drawable.detail_pisces
            Sagittarius -> R.drawable.detail_sagittarius
            Taurus -> R.drawable.detail_taurus
            Virgo -> R.drawable.detail_virgo
        }

        binding.ivDetail.setImageResource(image)
    }

    private fun errorState() {
        binding.progressBar.isVisible = false

    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }
}