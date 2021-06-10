package com.pasukanlangit.id.offlinecachingflow.data

import androidx.room.withTransaction
import com.pasukanlangit.id.offlinecachingflow.data.api.RestaurantApi
import com.pasukanlangit.id.offlinecachingflow.data.room.RestaurantDatabase
import com.pasukanlangit.id.offlinecachingflow.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurant()
        },
        fetch = {
            delay(2000)
            api.getAllRestaurant()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurant()
                restaurantDao.insertRestaurant(restaurants)
            }
        }
    )
}