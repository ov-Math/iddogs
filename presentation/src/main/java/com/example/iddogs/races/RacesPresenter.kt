package com.example.iddogs.races

import com.example.domain.interactor.GetDogRaces
import com.example.domain.interactor.GetDogs
import com.example.domain.model.DogRacesDomain
import com.example.iddogs.core.BasePresenter
import com.example.iddogs.core.Navigator
import com.example.iddogs.models.Feed

class RacesPresenter (private val navigator: Navigator,
                        private val getDogRaces: GetDogRaces,
                        private val getDogs: GetDogs) : BasePresenter<RacesView>() {

    val raceList = getDogRaces.execute()

    fun getDogsByRace(race : DogRacesDomain) {
        view?.showLoading()
        getDogs
            .with(race)
            .execute()
            .subscribe({
                navigator.navigateDogFeed(Feed.fromDomainObject(it))
            },{
                view?.hideLoading()
                view?.showGenericError()
            })
    }
}