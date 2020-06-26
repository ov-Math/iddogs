package com.example.iddogs.races

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.domain.model.DogRacesDomain
import com.example.iddogs.R
import com.example.iddogs.core.BaseActivity
import com.example.iddogs.core.Navigator

class RacesActivity : BaseActivity(), RacesView {

    private val presenter = RacesPresenter(Navigator(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_races)

        presenter.attachView(this)
    }

    override fun onRaceSelected(race : DogRacesDomain) {

    }
}