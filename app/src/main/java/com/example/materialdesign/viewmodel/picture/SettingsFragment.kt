package com.example.materialdesign.viewmodel.picture

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import com.example.materialdesign.R
import com.example.materialdesign.databinding.FragmentSettingsBinding
import com.google.android.material.tabs.TabLayout


class SettingsFragment : Fragment() {


    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding
        get() = _binding!!

    var settingsPosition = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()

        setSettingsPosition()

        setTabs()
    }

    fun setSettingsPosition() {
        settingsPosition = if (settingsPosition) {
            binding.settingsImage.load(R.drawable.original)
            false
        } else {
            binding.settingsImage.load(R.drawable.colorblind)
            true
        }

        binding.colorblindTheme.setOnClickListener {
            requireActivity().setTheme(R.style.MyСolorBlind_Theme)
            binding.settingsImage.load(R.drawable.colorblind)
            settingsPosition = false
            saveData()
        }

        binding.normalTheme.setOnClickListener {
            requireActivity().setTheme(R.style.Theme_MaterialDesign)
            binding.settingsImage.load(R.drawable.original)
            settingsPosition = true
            saveData()
        }

    }

    private fun saveData() {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putBoolean("settingsPosition", settingsPosition)
        }.apply()

    }

    fun loadData() {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val savedBoolean = sharedPreferences.getBoolean("settingsPosition", true)
        settingsPosition = savedBoolean

    }

    private fun setTabs() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "${tab?.position}", Toast.LENGTH_LONG).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }
        })
    }


    companion object {

        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}