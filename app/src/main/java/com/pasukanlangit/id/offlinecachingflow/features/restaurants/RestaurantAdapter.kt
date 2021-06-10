package com.pasukanlangit.id.offlinecachingflow.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pasukanlangit.id.offlinecachingflow.data.RestaurantResponseItem
import com.pasukanlangit.id.offlinecachingflow.databinding.RestaurantItemBinding

class RestaurantAdapter : ListAdapter<RestaurantResponseItem, RestaurantAdapter.RestaurantViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RestaurantResponseItem>(){
            override fun areItemsTheSame(
                oldItem: RestaurantResponseItem,
                newItem: RestaurantResponseItem
            ) = oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: RestaurantResponseItem,
                newItem: RestaurantResponseItem
            ) = oldItem == newItem
        }
    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: RestaurantResponseItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(currentItem.logo)
                    .into(ivLogo)

                tvName.text = currentItem.name
                tvType.text = currentItem.type
                tvAddress.text = currentItem.address
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantViewHolder {
        val view = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder:RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}