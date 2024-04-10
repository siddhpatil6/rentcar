package com.example.rentcar.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentcar.Adapter.CarAdapter
import com.example.rentcar.ReplaceFragmentInterface
import com.example.rentcar.databinding.FragmentAllcarBinding
import com.example.rentcar.ui.CarListViewModel
import com.example.rentcar.ui.di.provider.CarListComponentProvider
import com.example.rentcar.ui.home.CarListViewModelFactory
import com.example.rentcar.ui.models.Result

class CarListFragment : Fragment(), ReplaceFragmentInterface {
    private lateinit var binding: FragmentAllcarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private val carListViewModel: CarListViewModel by viewModels { CarListViewModelFactory() }

    init {
        CarListComponentProvider.getCarListComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllcarBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carListViewModel.getCarListData()
        val adapter= CarAdapter(this)
        binding.AllcarRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.AllcarRecyclerView.adapter = adapter
        carListViewModel.getCarListData()

        carListViewModel.carListLiveData.observe(viewLifecycleOwner, { carListResponseModel ->
            adapter.submitList(carListResponseModel.result)
        })

    }
    companion object {
    }

    override fun callCarDetailActivity(fragment: Result) {
        // Create a FragmentManager
        val intent = Intent(context, CarDetailActivity::class.java)
        intent.putExtra("carItem",fragment)
        startActivity(intent)
    }
}
