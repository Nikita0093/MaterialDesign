package com.example.materialdesign.lesson_4_layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentLayoutsBinding
import com.example.materialdesign.lesson_4_layouts.fragments.ConstraintFragment
import com.example.materialdesign.lesson_4_layouts.fragments.CoordinatorFragment
import com.example.materialdesign.lesson_4_layouts.fragments.MotionFragment


class LayoutsFragment : Fragment() {


    private var _binding: FragmentLayoutsBinding? = null
    private val binding: FragmentLayoutsBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLayoutsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationTo(ConstraintFragment.newInstance())


        binding.bottomNaviLayouts.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.bottom_navi_constraint -> {
                    navigationTo(ConstraintFragment.newInstance())
                    Toast.makeText(requireContext(), "One", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.bottom_navi_coordinator -> {
                    navigationTo(CoordinatorFragment.newInstance())
                    Toast.makeText(requireContext(), "Two", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.bottom_navi_motion -> {
                    navigationTo(MotionFragment.newInstance())
                    Toast.makeText(requireContext(), "Three", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true

            }
        }
    }

    private fun navigationTo(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.layout_container, fragment).addToBackStack(" ").commit()
    }


    companion object {

        @JvmStatic
        fun newInstance() = LayoutsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}