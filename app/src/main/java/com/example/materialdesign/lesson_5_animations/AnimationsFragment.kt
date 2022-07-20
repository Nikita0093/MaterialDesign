package com.example.materialdesign.lesson_5_animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.example.materialdesign.databinding.FragmentAnimationsBinding


class AnimationsFragment : Fragment() {


    private var _binding: FragmentAnimationsBinding? = null
    private val binding: FragmentAnimationsBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAnimationsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var isOpen = false

        binding.animationButton.setOnClickListener {

            TransitionManager.beginDelayedTransition(binding.root)

            isOpen = !isOpen

            binding.animationText.visibility = if (isOpen) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }


    }


    companion object {

        @JvmStatic
        fun newInstance() = AnimationsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}