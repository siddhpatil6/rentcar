package com.example.rentcar.ui.fragment

import DatePickerFragment
import android.os.Bundle
import android.widget.Toast

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.models.SlideModel
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.example.rentcar.DateSelectedListener
import com.example.rentcar.R
import com.example.rentcar.TimeSelectedListener
import com.example.rentcar.custom.PreferenceManager
import com.example.rentcar.databinding.ActivityCar1DataBinding
import com.example.rentcar.dialog.TimePickerFragment
import com.example.rentcar.ui.CarListViewModel
import com.example.rentcar.ui.home.CarListViewModelFactory
import com.example.rentcar.ui.models.AddOrderRequestModel
import com.example.rentcar.ui.models.ProfileResponseModel
import com.example.rentcar.ui.models.Result

class CarDetailActivity : AppCompatActivity(), DateSelectedListener,TimeSelectedListener  {
    private lateinit var binding: ActivityCar1DataBinding
    private val carListViewModel: CarListViewModel by viewModels { CarListViewModelFactory() }
    private var item: Result? = null
    private var profileResponseModel: ProfileResponseModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCar1DataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        item = intent.getParcelableExtra("carItem") as Result?
        profileResponseModel = PreferenceManager(applicationContext).getProfile()

        // Initialize image slider
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.car1))
        // Add other images to imageList

        binding.car1slider.setImageList(imageList, ScaleTypes.CENTER_CROP)

        binding.btnSelectDate.setOnClickListener {
            val newFragment = DatePickerFragment()
            newFragment.setDateSelectedListener(this)
            newFragment.show(supportFragmentManager, "datePicker")
        }

        binding.btnSelectTime.setOnClickListener {
            val newFragment = TimePickerFragment()
            newFragment.setTimeSelectedListener(this)
            newFragment.show(supportFragmentManager, "timePicker")

        }


        carListViewModel.orderReponseLiveData.observe(this) {
            Toast.makeText(applicationContext, "Car Successfully Booked.", Toast.LENGTH_SHORT).show()
            fragmentManager?.popBackStack()
        }

        binding.btnConfirmBooking.setOnClickListener {
            carListViewModel.addCarBookingOrder(addCarBookingOrder = AddOrderRequestModel(car_id = item?._id?:"", date =binding.txtSelectDate.text.toString(), time = binding.txtSelectTime.text.toString(), order_prize = item?.price ?:"", user_id = profileResponseModel?.user?._id?:""))
        }

        // Update UI with car details
        item?.let {
            binding.tvCarName.text = it.carName
            binding.tvCarSeats.text = it.seats
            binding.tvPrice.text = it.price
            binding.tvDetail.text = it.details
        }
    }

    private fun showDatePickerDialog() {
        // Implement date picker dialog logic here
    }

    private fun showTimePickerDialog() {
        // Implement time picker dialog logic here
    }

    private fun confirmBooking() {
        // Handle booking confirmation logic here
    }

    override fun onDateSelected(year: Int, month: Int, dayOfMonth: Int) {
        binding.txtSelectDate.text = "$dayOfMonth / $month / $year"
    }

    override fun onTimeSelected(hourOfDay: Int, minute: Int) {
        binding.txtSelectTime.text = "$hourOfDay : $minute"
    }
}


