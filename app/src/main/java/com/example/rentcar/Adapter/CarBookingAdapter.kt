package com.example.rentcar.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rentcar.databinding.ItemCarBookingBinding
import com.example.rentcar.ui.models.Order

class CarBookingAdapter :
    ListAdapter<Order, CarBookingAdapter.OrderViewHolder>(OrderDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemCarBookingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class OrderViewHolder(private val binding: ItemCarBookingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Order) {
            binding.apply {
                carNameTextView.text = item.car_id.carName
                carTypeTextView.text = item.car_id.type
                seatsTextView.text = "Seats: ${item.car_id.seats}"
                dateTextView.text = "Date: ${item.date}"
                timeTextView.text = "Time: ${item.time}"
            }
        }
    }

    class OrderDiffCallback : DiffUtil.ItemCallback<Order>() {
        override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem == newItem
        }
    }
}