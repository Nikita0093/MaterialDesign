package com.example.materialdesign.lesson_4_layouts.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign.databinding.FragmentConstraintBinding
import com.example.materialdesign.databinding.FragmentMotionBinding


class MotionFragment : Fragment() {


    private var _binding: FragmentMotionBinding? = null
    private val binding: FragmentMotionBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMotionBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    companion object {

        @JvmStatic
        fun newInstance() = MotionFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}