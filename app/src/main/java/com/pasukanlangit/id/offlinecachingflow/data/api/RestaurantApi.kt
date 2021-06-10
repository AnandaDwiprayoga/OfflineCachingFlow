package com.pasukanlangit.id.offlinecachingflow.data.api

import com.pasukanlangit.id.offlinecachingflow.data.RestaurantResponseItem
import retrofit2.http.GET

interface RestaurantApi {
    companion object {
        const val  BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getAllRestaurant() : List<RestaurantResponseItem>
}