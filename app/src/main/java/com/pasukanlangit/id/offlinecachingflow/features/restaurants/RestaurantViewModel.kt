package com.pasukanlangit.id.offlinecachingflow.features.restaurants

import androidx.lifecycle.*
import com.pasukanlangit.id.offlinecachingflow.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
): ViewModel(){

    val restaurants = repository.getRestaurants().asLiveData()

//    private val _restaurantLiveData = MutableLiveData<List<RestaurantResponseItem>>()
//    val restaurantLiveData : LiveData<List<RestaurantResponseItem>> = _restaurantLiveData
//
//    init {
//        viewModelScope.launch {
//            val restaurant = api.getAllRestaurant()
//            delay(2000)
//            _restaurantLiveData.postValue(restaurant)
//        }
//    }
}