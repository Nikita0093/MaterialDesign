package com.example.materialdesign.viewmodel.picture

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentPictureOfTheDayBinding
import com.google.android.material.snackbar.Snackbar

class PictureOfTheDayFragment : Fragment() {
    private var _binding: FragmentPictureOfTheDayBinding? = null
    private val binding: FragmentPictureOfTheDayBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLiveData().observe(viewLifecycleOwner, Observer {
            renderData(it)

        })
        viewModel.getPictureOfTheDayByViewModel()

    }

    private fun renderData(pictureOfTheDayAppState: PictureOfTheDayAppState) {
        when (pictureOfTheDayAppState) {

            is PictureOfTheDayAppState.Error -> {
                binding.progressBar.visibility = View.INVISIBLE
                Snackbar.make(
                    requireView(),
                    "Ошибка: $pictureOfTheDayAppState",
                    Snackbar.LENGTH_LONG
                ).show()
                Log.d("@@@", "$pictureOfTheDayAppState")
            }

            is PictureOfTheDayAppState.Loading -> {
                //binding.progressBar.visibility = View.VISIBLE
            }

            is PictureOfTheDayAppState.Success -> {
                binding.progressBar.visibility = View.INVISIBLE
                binding.imageView.load(pictureOfTheDayAppState.pictureOfTheDayResponseData.hdurl) {
                    placeholder(R.drawable.nasa_logo)
                }
            }
        }


    }


    companion object {

        @JvmStatic
        fun newInstance() = PictureOfTheDayFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}