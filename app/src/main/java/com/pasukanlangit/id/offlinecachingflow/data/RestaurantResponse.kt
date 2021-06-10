package com.pasukanlangit.id.offlinecachingflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "restaurant")
data class RestaurantResponseItem(

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("review")
	val review: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("logo")
	val logo: String,

	@PrimaryKey
	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("type")
	val type: String
)
