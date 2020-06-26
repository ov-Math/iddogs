package com.example.iddogs.dogfeed

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iddogs.R
import com.example.iddogs.core.BaseActivity
import com.example.iddogs.core.Navigator
import kotlinx.android.synthetic.main.activity_dog_feed.*

class DogFeedActivity : BaseActivity(), DogFeedView {

    private val presenter = DogFeedPresenter(Navigator(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_feed)

        presenter.attachView(this)

        presenter.feed = intent.getParcelableExtra(DogFeedPresenter.DOG_FEED)

        list.adapter = DogFeedAdapter(presenter.feed.imageList, this)
        list.layoutManager = GridLayoutManager(this, 3)

        activityTitle.text = presenter.feed.race?.name?.capitalize() ?: ""

        hideLoading()
    }

    override fun onImageSelected(path: String) {
        presenter.navigateDogZoom(path)
    }
}