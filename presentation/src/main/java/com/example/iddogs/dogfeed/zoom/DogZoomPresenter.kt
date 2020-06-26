package com.example.iddogs.dogfeed.zoom

import com.example.iddogs.core.BasePresenter

class DogZoomPresenter() : BasePresenter<DogZoomView>() {

    companion object {
        const val IMAGE_PATH = "IMAGE_PATH"
    }

    var imagePath : String = ""
}