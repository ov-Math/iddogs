package com.example.domain.interactor

import com.example.domain.core.CacheKey
import com.example.domain.core.CacheRepository
import com.example.domain.core.DogRepository
import com.example.domain.model.DogRacesDomain
import com.example.domain.model.FeedDomain
import com.example.domain.model.UserDomain
import io.reactivex.rxjava3.core.Single

class GetDogs(private val repository: DogRepository,
              private val cacheRepository: CacheRepository) {

    private var race : DogRacesDomain? = null

    fun with(race : DogRacesDomain?) : GetDogs {
        this.race = race
        return this
    }

    fun execute() : Single<FeedDomain> {
        val currentUser = cacheRepository.getObject(CacheKey.USER, UserDomain::class.java) as UserDomain
        return repository.getDogs(this.race, currentUser.token)
    }
}