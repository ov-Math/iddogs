package com.example.iddogs.dogfeed.zoom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.iddogs.R
import com.example.iddogs.core.BaseActivity
import com.example.iddogs.dogfeed.DogFeedActivity
import kotlinx.android.synthetic.main.activity_dog_zoom.*

class DogZoomActivity : BaseActivity(), DogZoomView {

    private val presenter = DogZoomPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_zoom)

        presenter.attachView(this)

        presenter.imagePath = intent.getStringExtra(DogZoomPresenter.IMAGE_PATH)

        loadFullSizeImage()
    }

    private fun loadFullSizeImage() {
        Glide.with(this).load(presenter.imagePath).into(image)
    }
}