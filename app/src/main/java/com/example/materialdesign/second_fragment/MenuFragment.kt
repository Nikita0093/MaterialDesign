package com.example.materialdesign.second_fragment

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentMenuBinding
import com.example.materialdesign.lesson3.viewpager.ViewPagerApiFragment
import com.example.materialdesign.viewmodel.picture.PictureOfTheDayFragment
import com.example.materialdesign.viewmodel.picture.WikiFragment


class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding!!
    private var music = MediaPlayer()
    var musicPosition = false

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
        playMusic()

    }

    private fun playMusic() {

        val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.track_two)
        music = mediaPlayer
        binding.buttonMusic.setOnClickListener {
            if (!musicPosition) {
                binding.buttonMusic.text = getString(R.string.stop)
                music.start()
                musicPosition = true

            } else {
                binding.buttonMusic.text = getString(R.string.play)
                music.stop()
                musicPosition = false

            }

        }
    }

    private fun saveData() {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putBoolean("musicPosition", musicPosition)
        }.apply()

    }

    fun loadData() {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val savedBoolean = sharedPreferences.getBoolean("musicPosition", false)
        musicPosition = savedBoolean

    }


    private fun setOnClickListener() {
        binding.buttonNasa.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, ViewPagerApiFragment.newInstance())
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

    override fun onStop() {
        super.onStop()
        music.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
