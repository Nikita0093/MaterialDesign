package com.example.materialdesign.viewmodel_earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.materialdesign.databinding.FragmentEarthBinding
import com.example.materialdesign.viewmodel.picture.PictureOfTheDayViewModel


class EarthFragment : Fragment() {


    private var _binding: FragmentEarthBinding? = null
    private val binding: FragmentEarthBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val viewModel: EarthCameraViewModel by lazy {
        ViewModelProvider(this).get(EarthCameraViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer {
            renderData(it)
        })

        viewModel.getEarthPictureByViewModel()
    }

    private fun renderData(earthCameraAppState: EarthCameraAppState) {
        when (earthCameraAppState) {

            is EarthCameraAppState.Error -> {}


            EarthCameraAppState.Loading -> {}



            is EarthCameraAppState.Success -> {
                binding.earthImageView.load(earthCameraAppState.earthCameraResponseData.image)
                binding.earthTextView.text = earthCameraAppState.earthCameraResponseData.caption
            }


        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = EarthFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}