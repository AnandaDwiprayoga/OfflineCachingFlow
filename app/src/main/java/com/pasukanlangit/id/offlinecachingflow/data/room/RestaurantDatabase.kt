package com.pasukanlangit.id.offlinecachingflow.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pasukanlangit.id.offlinecachingflow.data.RestaurantResponseItem

@Database(entities = [RestaurantResponseItem::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}