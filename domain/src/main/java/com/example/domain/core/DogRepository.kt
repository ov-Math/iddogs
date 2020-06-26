package com.example.domain.core

import com.example.domain.model.DogRacesDomain
import com.example.domain.model.FeedDomain
import io.reactivex.rxjava3.core.Single

interface DogRepository {
    fun getDogRaceList() : List<DogRacesDomain>
    fun getDogs(race : DogRacesDomain?, authorizationToken: String) : Single<FeedDomain>
}