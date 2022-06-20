package com.example.materialdesign.lesson3.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentViewpagerApiBinding


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

        binding.mainViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //TODO("Not yet implemented")
            }

            override fun onPageSelected(position: Int) {
                /*when (position) {
                    0 -> {
                        binding.pageOne.setImageResource(R.drawable.ic_dot_main)
                        binding.pageTwo.setImageResource(R.drawable.ic_dot_other)
                        binding.pageThree.setImageResource(R.drawable.ic_dot_other)

                    }
                    1 -> {
                        binding.pageOne.setImageResource(R.drawable.ic_dot_other)
                        binding.pageTwo.setImageResource(R.drawable.ic_dot_main)
                        binding.pageThree.setImageResource(R.drawable.ic_dot_other)
                    }
                    2 -> {
                        binding.pageOne.setImageResource(R.drawable.ic_dot_other)
                        binding.pageTwo.setImageResource(R.drawable.ic_dot_other)
                        binding.pageThree.setImageResource(R.drawable.ic_dot_main)
                    }


                }

                 */
            }

            override fun onPageScrollStateChanged(state: Int) {
                //TODO("Not yet implemented")
            }
        })
        binding.viewPagerTab.getTabAt(0)?.setIcon(R.drawable.ic_earth)
        binding.viewPagerTab.getTabAt(1)?.setIcon(R.drawable.ic_mars)
        binding.viewPagerTab.getTabAt(2)?.setIcon(R.drawable.ic_solar_system)
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
