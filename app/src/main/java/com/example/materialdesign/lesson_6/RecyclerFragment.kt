package com.example.materialdesign.lesson_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign.databinding.FragmentRecyclerBinding
import com.example.materialdesign.utils.TYPE_EARTH
import com.example.materialdesign.utils.TYPE_MARS
import com.example.materialdesign.utils.TYPE_TITLE


class RecyclerFragment : Fragment() {


    private var _binding: FragmentRecyclerBinding? = null
    private val binding: FragmentRecyclerBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            Data("Title", " ", TYPE_TITLE),
            Data("Mars", "Mars des", TYPE_MARS),
            Data("Earth", "Earth des", TYPE_EARTH),
            Data("Title", " ", TYPE_TITLE),
            Data("Mars", "Mars des", TYPE_MARS),
            Data("Earth", "Earth des", TYPE_EARTH)
        )

        binding.recyclerView.adapter = RecyclerAdapter(list)


    }


    companion object {

        @JvmStatic
        fun newInstance() = RecyclerFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}