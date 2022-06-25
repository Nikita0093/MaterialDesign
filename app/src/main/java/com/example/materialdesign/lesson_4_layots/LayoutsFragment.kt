package com.example.materialdesign.lesson_4_layots

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign.databinding.FragmentLayoutsBinding
import com.example.materialdesign.databinding.FragmentMarsBinding


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