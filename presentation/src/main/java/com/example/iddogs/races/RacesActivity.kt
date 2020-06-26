package com.example.iddogs.races

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.repository.DogRepositoryImpl
import com.example.domain.interactor.GetDogRaces
import com.example.domain.model.DogRacesDomain
import com.example.iddogs.R
import com.example.iddogs.core.BaseActivity
import com.example.iddogs.core.Navigator
import kotlinx.android.synthetic.main.activity_races.*

class RacesActivity : BaseActivity(), RacesView {

    private val presenter = RacesPresenter(Navigator(this),
                                            GetDogRaces(DogRepositoryImpl())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_races)

        presenter.attachView(this)

        list.adapter = RacesListAdapter(presenter.raceList, this)
        list.layoutManager = LinearLayoutManager(this)
    }

    override fun onRaceSelected(race : DogRacesDomain) {

    }
}