package com.example.data.entity

import com.example.domain.core.DomainMappable
import com.example.domain.model.DogRacesDomain
import com.example.domain.model.FeedDomain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FeedResponse (@Expose @SerializedName("category") var race : String? = "",
                   @Expose @SerializedName("list") var imageList : List<String>? = mutableListOf()) : DomainMappable<FeedDomain> {

    override fun asDomainModel(): FeedDomain {
        return FeedDomain(DogRacesDomain.valueOf(race!!.toUpperCase()), imageList)
    }
}