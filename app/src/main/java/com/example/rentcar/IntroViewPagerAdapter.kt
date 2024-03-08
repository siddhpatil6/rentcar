package com.example.rentcar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.rentcar.ui.fragment.SliderFourFragment
import com.example.rentcar.ui.fragment.SliderOneFragment
import com.example.rentcar.ui.fragment.SliderThreeFragment
import com.example.rentcar.ui.fragment.SliderTwoFragment

class IntroViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentStatePagerAdapter(supportFragmentManager) {
 override fun getItem(position: Int): Fragment {
  when(position){
   0->return SliderOneFragment()
   1->return SliderTwoFragment()
   2->return SliderThreeFragment()
   else-> SliderFourFragment()
  }
  return SliderFourFragment()
}
 override fun getCount(): Int {
  return 4
 }
}