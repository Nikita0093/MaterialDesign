package com.example.materialdesign.lesson3.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentViewpagerApiBinding
import com.example.materialdesign.lesson3.MarsFragment
import com.example.materialdesign.lesson3.SolarSystemFragment
import com.example.materialdesign.viewmodel_earth.EarthFragment


class ViewPagerApiFragment : Fragment() {


    private var _binding: FragmentViewpagerApiBinding? = null
    private val binding: FragmentViewpagerApiBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentViewpagerApiBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainViewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)
        binding.viewPagerTab.setupWithViewPager(binding.mainViewPager)
        binding.viewPagerTab.getTabAt(0)?.setIcon(R.drawable.ic_earth)
        binding.viewPagerTab.getTabAt(1)?.setIcon(R.drawable.ic_mars)
        binding.viewPagerTab.getTabAt(2)?.setIcon(R.drawable.ic_solar_system)

        binding.bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.bottom_app_earth -> requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.mainContainer,
                        EarthFragment.newInstance()
                    ).addToBackStack(" ").commit()

                R.id.bottom_app_mars -> requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.mainContainer,
                        MarsFragment.newInstance()
                    ).addToBackStack(" ").commit()

                R.id.bottom_app_solar -> requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.mainContainer,
                        SolarSystemFragment.newInstance()
                    ).addToBackStack(" ").commit()

            }

            true
        }


    }


    companion object {

        @JvmStatic
        fun newInstance() = ViewPagerApiFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
