package com.example.rentcar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.rentcar.Adapter.CarAdapter
import com.example.rentcar.R
import com.example.rentcar.databinding.FragmentHomeBinding
import com.example.rentcar.ui.CarListViewModel
import com.example.rentcar.ui.di.provider.CarListComponentProvider
import com.example.rentcar.ui.home.CarListViewModelFactory

class HomeFragment : Fragment(), ReplaceFragmentInterface,LifecycleOwner {
    private lateinit var binding: FragmentHomeBinding

    private val carListViewModel: CarListViewModel by viewModels { CarListViewModelFactory() }

    init {
        CarListComponentProvider.getCarListComponent().inject(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.exploremoretxt.setOnClickListener {
            replaceFragment(AllcarFragment())
        }

        return binding.root

    }

    override fun replaceFragment(fragment: Fragment) {
        // Create a FragmentManager
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        // Begin a transaction
        val transaction = fragmentManager.beginTransaction()

        // Replace the current fragment with the new fragment
        transaction.replace(R.id.nav_host_fragment, fragment)

        // Add the transaction to the back stack (optional)
        transaction.addToBackStack(null)

        // Commit the transaction
        transaction.commit()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imagelist)
        imageSlider.setImageList(imagelist,ScaleTypes.FIT)


        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imagelist[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }


        })


        carListViewModel.getCarListData()
        val adapter= CarAdapter(this)
        binding.PopularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter = adapter

        carListViewModel.carListLiveData.observe(viewLifecycleOwner, Observer { carListResponseModel ->
            adapter.carList.clear()
            adapter.carList.addAll(carListResponseModel.cars)
            adapter.notifyDataSetChanged()

        })

    }
    companion object {

    }

}

interface ReplaceFragmentInterface{
    fun replaceFragment(fragment: Fragment)
}