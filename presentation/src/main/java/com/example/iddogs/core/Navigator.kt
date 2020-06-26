package com.example.iddogs.core

import android.content.Intent
import com.example.iddogs.dogfeed.DogFeedActivity
import com.example.iddogs.dogfeed.DogFeedPresenter
import com.example.iddogs.models.Feed
import com.example.iddogs.races.RacesActivity

class Navigator (private val activity: BaseActivity) {

    fun navigateRacesList() {
        val intent = Intent(activity, RacesActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        activity.startActivity(intent)
    }

    fun navigateDogFeed(feed : Feed) {
        val intent = Intent(activity, DogFeedActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        intent.putExtra(DogFeedPresenter.DOG_FEED, feed)
        activity.startActivity(intent)
    }

}