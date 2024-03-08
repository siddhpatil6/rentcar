package com.example.rentcar.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rentcar.R
import com.example.rentcar.ui.fragment.CarDataFragment
import com.example.rentcar.ui.fragment.ReplaceFragmentInterface
import com.example.rentcar.databinding.CarItemBinding
import com.example.rentcar.ui.response.Car


class CarAdapter(private val requireFragmentInterface: ReplaceFragmentInterface) : RecyclerView.Adapter<CarAdapter.PopularViewHolder>() {

    var carList = mutableListOf<Car>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(CarItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return carList.size
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(carList.get(position), requireFragmentInterface = requireFragmentInterface)
    }

    class PopularViewHolder (private val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.ivcarall
        fun bind(item:Car, requireFragmentInterface: ReplaceFragmentInterface){
            binding.cnalltxt.text = item.name
            binding.priceofalltxt.text = item.price
            binding.seatsalltxt.text = item.seats.toString()

            Glide.with(binding.root.context)
                .load(item.img)
                .placeholder(R.drawable.ic_car) // Optional placeholder image while loading
                .error(R.drawable.ic_car) // Optional error image if the load fails
                .into(imagesView)

            binding.root.setOnClickListener {
                requireFragmentInterface.replaceFragment(CarDataFragment())
            }
        }
    }

}