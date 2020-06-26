package com.example.iddogs.races

import com.example.domain.interactor.GetDogRaces
import com.example.iddogs.core.BasePresenter
import com.example.iddogs.core.Navigator

class RacesPresenter (private val navigator: Navigator,
                        private val getDogRaces: GetDogRaces) : BasePresenter<RacesView>() {

    val raceList = getDogRaces.execute()
}