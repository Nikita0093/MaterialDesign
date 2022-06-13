package com.example.materialdesign.second_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentMenuBinding
import com.example.materialdesign.viewmodel.picture.PictureOfTheDayFragment
import com.example.materialdesign.viewmodel.picture.WikiFragment


class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }


    private fun setOnClickListener() {
        binding.buttonNasa.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, PictureOfTheDayFragment.newInstance())
                .addToBackStack(" ").commit()
        }
        binding.buttonWiki.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, WikiFragment.newInstance()).addToBackStack(" ")
                .commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MenuFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
