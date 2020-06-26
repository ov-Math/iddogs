package com.example.data.repository

import com.example.domain.core.DogRepository
import com.example.domain.model.DogRacesDomain

class DogRepositoryImpl : DogRepository {

    override fun getDogRaceList(): List<DogRacesDomain> {
        return mutableListOf(DogRacesDomain.HUSKY, DogRacesDomain.HOUND, DogRacesDomain.LABRADOR, DogRacesDomain.PUG)
    }

}