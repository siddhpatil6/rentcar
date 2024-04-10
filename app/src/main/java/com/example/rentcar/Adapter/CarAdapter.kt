package com.example.rentcar.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rentcar.R
import com.example.rentcar.ReplaceFragmentInterface
import com.example.rentcar.databinding.CarItemBinding
import com.example.rentcar.ui.models.Result


class CarAdapter(private val requireFragmentInterface: ReplaceFragmentInterface) :
    ListAdapter<Result, CarAdapter.PopularViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            CarItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PopularViewHolder(private val binding: CarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.ivcarall
        fun bind(item: Result) {
            binding.cnalltxt.text = item.carName
            binding.priceofalltxt.text = item.price
            binding.seatsalltxt.text = item.seats.toString()

            Glide.with(binding.root.context)
                .load(item.carImages.firstOrNull())
                .placeholder(R.drawable.ic_car) // Optional placeholder image while loading
                .error(R.drawable.ic_car) // Optional error image if the load fails
                .into(imagesView)

            binding.root.setOnClickListener {
                requireFragmentInterface.callCarDetailActivity(item)
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }
}
