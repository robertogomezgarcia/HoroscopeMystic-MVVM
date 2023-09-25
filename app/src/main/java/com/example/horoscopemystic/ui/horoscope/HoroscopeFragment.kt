package com.example.horoscopemystic.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.horoscopemystic.databinding.FragmentHoroscopeBinding
import com.example.horoscopemystic.domain.model.HoroscopeInfo
import com.example.horoscopemystic.domain.model.HoroscopeInfo.*
import com.example.horoscopemystic.domain.model.HoroscopeModel
import com.example.horoscopemystic.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecycler()
        initUIState()
    }

    private fun initRecycler() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            val type = when(it){
                Aquario -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricornio -> HoroscopeModel.Capricorn
                Geminis -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Piscis -> HoroscopeModel.Pisces
                Sagitario -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Tauro -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        })


        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }

    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}