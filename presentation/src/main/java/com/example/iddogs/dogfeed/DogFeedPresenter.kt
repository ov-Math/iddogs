package com.example.iddogs.dogfeed

import com.example.iddogs.core.BasePresenter
import com.example.iddogs.core.Navigator
import com.example.iddogs.models.Feed

class DogFeedPresenter (private val navigator: Navigator) : BasePresenter<DogFeedView>() {

    companion object {
        const val DOG_FEED = "DOG_FEED"
    }

    lateinit var feed : Feed

    fun navigateDogZoom(uri : String) {
        navigator.navigateDogZoom(uri)
    }
}