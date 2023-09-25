package com.example.horoscopemystic.domain.usecase

import com.example.horoscopemystic.domain.model.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

   suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}