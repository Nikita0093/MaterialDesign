package com.example.materialdesign.lesson3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign.databinding.FragmentSettingsBinding
import com.example.materialdesign.databinding.FragmentSolarSystemBinding


class SolarSystemFragment : Fragment() {


    private var _binding: FragmentSolarSystemBinding? = null
    private val binding: FragmentSolarSystemBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSolarSystemBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {

        @JvmStatic
        fun newInstance() = SolarSystemFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}