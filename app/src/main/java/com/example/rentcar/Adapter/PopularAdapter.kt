package com.example.rentcar.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rentcar.databinding.PopularItemBinding

class PopularAdapter(private val items:List<String>,private val price:List<String>,private val image:List<Int>, private val seats:List<String>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
       val item =items[position]
        val images= image[position]
        val price= price[position]
        val seats= seats[position]
        holder.bind(item,price,images,seats)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.ivcar
        fun bind(item: String, price: String, images: Int, seats: String){
            binding.cnpopular.text = item
            binding.pricepopular.text = price
            imagesView.setImageResource(images)
            binding.seatstxt.text = seats

        }
    }

}