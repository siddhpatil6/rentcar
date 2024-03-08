package com.example.rentcar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentcar.Adapter.CarAdapter
import com.example.rentcar.R
import com.example.rentcar.databinding.FragmentAllcarBinding
import com.example.rentcar.ui.CarListViewModel
import com.example.rentcar.ui.di.provider.CarListComponentProvider
import com.example.rentcar.ui.home.CarListViewModelFactory

class AllcarFragment : Fragment(), ReplaceFragmentInterface {
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

        val Carname = listOf("1", "2", "3", "4", "5", "6","7","8","9","10","11","12","13","14","15","16")
        val Price = listOf("₹150/hr", "₹100/hr", "₹180/hr", "₹131/hr", "₹100/hr", "₹168/hr","₹90/hr","₹150/hr","₹140/hr","₹125/hr","₹160/hr","₹121/hr","₹128/hr","₹180/hr","₹120/hr","₹128/hr")
        val Seats = listOf("5 seats", "7 seats", "4 seats", "7 seats", "5 seats", "4 seats","4 seats","4 seats","6 seats","4 seats","5 seats","4 seats","4 seats","5 seats","4 seats","4 seats")
        val AllCarImages =
            listOf(
                R.drawable.car1,
                R.drawable.car2,
                R.drawable.car3,
                R.drawable.car4,
                R.drawable.car5,
                R.drawable.car6,
                R.drawable.car7,
                R.drawable.car8,
                R.drawable.car9,
                R.drawable.car10,
                R.drawable.car11,
                R.drawable.car12,
                R.drawable.car13,
                R.drawable.car14,
                R.drawable.car15,
                R.drawable.car16
            )
        carListViewModel.getCarListData()
        val adapter= CarAdapter(this)
        binding.AllcarRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.AllcarRecyclerView.adapter = adapter
        carListViewModel.getCarListData()


        carListViewModel.carListLiveData.observe(viewLifecycleOwner, Observer { carListResponseModel ->
            adapter.carList.clear()
            adapter.carList.addAll(carListResponseModel.cars)
            adapter.notifyDataSetChanged()

        })

    }
    companion object {
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
}
