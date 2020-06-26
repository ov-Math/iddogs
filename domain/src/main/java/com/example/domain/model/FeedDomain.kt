package com.example.domain.model

import com.example.domain.core.DomainModel

class FeedDomain (var category: DogRacesDomain? = null,
                  var imageList: List<String>? = mutableListOf()) : DomainModel {
}