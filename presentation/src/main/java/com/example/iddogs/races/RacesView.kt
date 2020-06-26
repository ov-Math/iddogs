package com.example.iddogs.races

import com.example.domain.model.DogRacesDomain
import com.example.iddogs.core.BaseView

interface RacesView : BaseView {
    fun onRaceSelected(race : DogRacesDomain)
    fun showGenericError()
}