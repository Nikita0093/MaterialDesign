package com.example.materialdesign.lesson3.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.materialdesign.lesson3.MarsFragment
import com.example.materialdesign.lesson3.SolarSystemFragment
import com.example.materialdesign.viewmodel.picture.PictureOfTheDayFragment
import com.example.materialdesign.viewmodel_earth.EarthFragment

class ViewPagerAdapter(private val fm: FragmentManager) : FragmentStatePagerAdapter(fm) {


    private val fragments =
        arrayOf(EarthFragment(), MarsFragment(), SolarSystemFragment(), PictureOfTheDayFragment())

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence {

        return when (position) {
            0 -> "Earth"
            1 -> "Mars"
            2 -> "Solar"
            else -> "Picture Of The Day"
        }
    }
}
