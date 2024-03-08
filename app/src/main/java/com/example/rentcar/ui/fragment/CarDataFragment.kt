package com.example.rentcar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.example.rentcar.R

class CarDataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_car1_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get reference to the ImageSlider
        val imageSlider: ImageSlider = view.findViewById(R.id.car1slider)

        // Create a list of SlideModel objects to hold the images
        val imageList = ArrayList<SlideModel>()

        // Add images to the list
        imageList.add(SlideModel(R.drawable.car1))
        imageList.add(SlideModel(R.drawable.car1_1))
        imageList.add(SlideModel(R.drawable.car1_2))
        imageList.add(SlideModel(R.drawable.car1_3))

        // Set the list of images to the ImageSlider
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
    }


}

