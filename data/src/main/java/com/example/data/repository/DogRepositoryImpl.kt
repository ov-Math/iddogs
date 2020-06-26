package com.example.data.repository

import com.example.data.services.ServicesFactory
import com.example.domain.core.DogRepository
import com.example.domain.model.DogRacesDomain
import com.example.domain.model.FeedDomain
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class DogRepositoryImpl : DogRepository {

    override fun getDogRaceList(): List<DogRacesDomain> {
        return mutableListOf(DogRacesDomain.HUSKY, DogRacesDomain.HOUND, DogRacesDomain.LABRADOR, DogRacesDomain.PUG)
    }

    override fun getDogs(race: DogRacesDomain?, authorizationToken: String): Single<FeedDomain> {
        return ServicesFactory.instance()
            .getDogServices(authorizationToken)
            .getDogs(race?.toString())
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.asDomainModel()
            }
    }

}