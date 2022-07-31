package com.example.materialdesign.lesson_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.materialdesign.databinding.FragmentRecyclerBinding
import com.example.materialdesign.utils.TYPE_EARTH
import com.example.materialdesign.utils.TYPE_MARS
import com.example.materialdesign.utils.TYPE_TITLE


class RecyclerFragment : Fragment(), OnListItemClickListener {


    private var _binding: FragmentRecyclerBinding? = null
    private val binding: FragmentRecyclerBinding
        get() = _binding!!

    private lateinit var adapter: RecyclerAdapter

    private val list = arrayListOf(
        Pair(Data("Title", " ", TYPE_TITLE), false),
        Pair(Data("Mars", "Mars des", TYPE_MARS), false),
        Pair(Data("Earth", "Earth des", TYPE_EARTH), false),
        Pair(Data("Earth", "Earth des", TYPE_EARTH), false),
        Pair(Data("Mars", "Mars des", TYPE_MARS), false),
        Pair(Data("Earth", "Earth des", TYPE_EARTH), false)
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = RecyclerAdapter(this)
        adapter.setList(list)
        binding.recyclerView.adapter = adapter


    }


    companion object {

        @JvmStatic
        fun newInstance() = RecyclerFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(data: Data) {

    }

    override fun onAddBtnClick(position: Int) {
        androidx.transition.TransitionManager.beginDelayedTransition(binding.root)
        list.add(position, Pair(Data("Mars", "Mars des", TYPE_MARS), false))
        adapter.setAddToList(list, position)

    }

    override fun onRemoveBtnClick(position: Int) {
        androidx.transition.TransitionManager.beginDelayedTransition(binding.root)
        list.removeAt(position)
        adapter.setRemoveToList(list, position)

    }

    override fun onMoveUp(position: Int) {
        if (position > 1) {
            list.removeAt(position).apply {
                list.add(position - 1, this)
                adapter.setMoveUpList(list, position)
            }

        } else {
            Toast.makeText(context, "Невозможно", Toast.LENGTH_SHORT).show()

        }


    }

    override fun onMoveDown(position: Int) {
        if (position < list.size - 1) {
            list.removeAt(position).apply {
                list.add(position + 1, this)
                adapter.setMoveDownList(list, position)
            }

        } else {
            Toast.makeText(context, "Невозможно", Toast.LENGTH_SHORT).show()
        }

    }
}