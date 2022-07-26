package com.example.materialdesign.lesson_5_animations

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.Explode
import androidx.transition.Fade
import androidx.transition.Slide
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

            val transitionFade = Slide(Gravity.END)
            val transitionExplode = Explode()
            transitionExplode.duration = 2000

            transitionFade.duration = 2000

            TransitionManager.beginDelayedTransition(binding.root, transitionExplode)

            isOpen = !isOpen

            binding.animationText.visibility = if (isOpen) {
                View.VISIBLE
            } else {
                View.GONE
            }
            binding.animationText2.visibility = if (isOpen) {
                View.VISIBLE
            } else {
                View.GONE
            }
            binding.animationText3.visibility = if (isOpen) {
                View.VISIBLE
            } else {
                View.GONE
            }
            binding.animationText4.visibility = if (isOpen) {
                View.VISIBLE
            } else {
                View.GONE
            }
            binding.animationText5.visibility = if (isOpen) {
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