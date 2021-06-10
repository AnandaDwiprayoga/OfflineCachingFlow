package com.pasukanlangit.id.offlinecachingflow.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pasukanlangit.id.offlinecachingflow.data.RestaurantResponseItem
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: List<RestaurantResponseItem>)

    @Query("DELETE FROM restaurant")
    suspend fun deleteAllRestaurant()

    @Query("SELECT * FROM restaurant")
    fun getAllRestaurant() : Flow<List<RestaurantResponseItem>>
}