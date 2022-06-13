package com.example.materialdesign.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.materialdesign.R
import com.example.materialdesign.databinding.BottomNavigationLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNaviDrawerFragment : BottomSheetDialogFragment() {

    private var _binding: BottomNavigationLayoutBinding? = null
    private val binding: BottomNavigationLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = BottomNavigationLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_one -> {
                    Toast.makeText(requireContext(), "На  экран 1", Toast.LENGTH_LONG).show()

                    dismiss()
                }

                R.id.navigation_two -> {
                    Toast.makeText(requireContext(), "На  экран 2", Toast.LENGTH_LONG).show()

                    dismiss()
                }


            }
            true
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = BottomNaviDrawerFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}