package com.pasukanlangit.id.offlinecachingflow.features.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasukanlangit.id.offlinecachingflow.databinding.ActivityRestaurantBinding
import com.pasukanlangit.id.offlinecachingflow.utils.Resource
import com.pasukanlangit.id.offlinecachingflow.utils.forceToImplement
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantBinding
    private val viewModel : RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()

        binding.apply {
            rvRestaurant.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }

            viewModel.restaurants.observe(this@RestaurantActivity){ result ->
                binding.apply {
                    loading.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                    tvError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                    tvError.text = result?.error?.localizedMessage

                }
                restaurantAdapter.submitList(result.data)
            }
        }
    }
}