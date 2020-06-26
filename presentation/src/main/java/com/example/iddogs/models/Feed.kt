package com.example.iddogs.models

import android.os.Parcelable
import com.example.domain.model.DogRacesDomain
import com.example.domain.model.FeedDomain
import kotlinx.android.parcel.Parcelize

@Parcelize
class Feed (var race : DogRacesDomain?,
            var imageList : List<String> = mutableListOf()) : Parcelable {

    companion object {
        fun fromDomainObject(obj : FeedDomain) : Feed {
            return Feed(obj.category,  obj.imageList ?: mutableListOf())
        }
    }
}