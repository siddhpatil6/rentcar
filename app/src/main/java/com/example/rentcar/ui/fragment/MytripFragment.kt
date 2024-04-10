package com.example.rentcar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentcar.Adapter.CarAdapter
import com.example.rentcar.Adapter.CarBookingAdapter
import com.example.rentcar.R
import com.example.rentcar.custom.PreferenceManager
import com.example.rentcar.databinding.FragmentMytripBinding
import com.example.rentcar.ui.CarListViewModel
import com.example.rentcar.ui.home.CarListViewModelFactory
import com.example.rentcar.ui.models.CarBooking
import com.example.rentcar.ui.models.OrderListRequestModel
import com.example.rentcar.ui.models.ProfileResponseModel


class MytripFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentMytripBinding
    private val carListViewModel: CarListViewModel by viewModels { CarListViewModelFactory() }
    private var profileResponseModel: ProfileResponseModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMytripBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileResponseModel = context?.let { PreferenceManager(it).getProfile() }

        val adapter = CarBookingAdapter()
        binding.rvOrderedList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOrderedList.adapter = adapter

        carListViewModel.orderListReponseLiveData.observe(viewLifecycleOwner, Observer { orderListResponseModel ->
            adapter.submitList(orderListResponseModel.orders)
            binding.rvOrderedList.adapter = adapter
        })
    }

    override fun onResume() {
        super.onResume()
        carListViewModel.getCarBookingList(OrderListRequestModel(userId = profileResponseModel?.user?._id ?:""))
    }

}