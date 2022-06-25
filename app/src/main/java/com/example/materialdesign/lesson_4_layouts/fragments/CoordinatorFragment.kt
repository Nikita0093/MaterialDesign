package com.example.materialdesign.lesson_4_layouts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign.databinding.FragmentConstraintBinding
import com.example.materialdesign.databinding.FragmentCoordinatorBinding


class CoordinatorFragment : Fragment() {


    private var _binding: FragmentCoordinatorBinding? = null
    private val binding: FragmentCoordinatorBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCoordinatorBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    companion object {

        @JvmStatic
        fun newInstance() = CoordinatorFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}