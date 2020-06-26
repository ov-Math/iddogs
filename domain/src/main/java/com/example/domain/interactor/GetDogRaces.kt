package com.example.domain.interactor

import com.example.domain.core.DogRepository
import com.example.domain.model.DogRacesDomain

class GetDogRaces(private val repository: DogRepository) {

    fun execute() : List<DogRacesDomain> {
        return repository.getDogRaceList()
    }
}
