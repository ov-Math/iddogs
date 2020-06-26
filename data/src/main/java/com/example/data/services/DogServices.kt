package com.example.data.services

import com.example.data.entity.FeedResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DogServices {

    @GET("feed")
    fun getDogs(
        @Query("category") race : String?
    ) : Single<FeedResponse>
}