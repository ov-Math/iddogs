package com.example.iddogs.dogfeed

import com.example.iddogs.core.BaseView

interface DogFeedView : BaseView {
    fun onImageSelected(path : String)
}