package com.example.domain.core

import com.example.domain.model.DogRacesDomain

interface DogRepository {
    fun getDogRaceList() : List<DogRacesDomain>
}