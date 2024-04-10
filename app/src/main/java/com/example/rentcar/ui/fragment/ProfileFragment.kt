package com.example.rentcar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.rentcar.R
import com.example.rentcar.custom.PreferenceManager
import com.example.rentcar.databinding.ActivityCar1DataBinding
import com.example.rentcar.databinding.FragmentProfileBinding
import com.example.rentcar.ui.CarListViewModel
import com.example.rentcar.ui.home.CarListViewModelFactory
import com.example.rentcar.ui.models.ProfileResponseModel
import com.example.rentcar.ui.models.UserDetailModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    private lateinit var binding:FragmentProfileBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefManager = context?.applicationContext?.let { PreferenceManager(it) }
        val profileResponseModel : ProfileResponseModel? = prefManager?.getProfile()
        binding.etEmail.setText(profileResponseModel?.user?.email.toString())
        binding.etMobile.setText(profileResponseModel?.user?.phone.toString())
        binding.etName.setText(profileResponseModel?.user?.name.toString())


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

}