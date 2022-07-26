package com.example.materialdesign.lesson_6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.databinding.FragmentRecyclerEarthBinding
import com.example.materialdesign.databinding.FragmentRecyclerMarsBinding
import com.example.materialdesign.utils.TYPE_EARTH
import com.example.materialdesign.utils.TYPE_MARS

class RecyclerAdapter(var list: List<Data>) : RecyclerView.Adapter<BaseViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            TYPE_EARTH -> {
                val view = FragmentRecyclerEarthBinding.inflate(LayoutInflater.from(parent.context))
                return EarthViewHolder(view.root)
            }
            TYPE_MARS -> {
                val view = FragmentRecyclerMarsBinding.inflate(LayoutInflater.from(parent.context))
                return MarsViewHolder(view.root)
            }
            else -> {
                val view = FragmentRecyclerEarthBinding.inflate(LayoutInflater.from(parent.context))
                return EarthViewHolder(view.root)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.myBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class EarthViewHolder(view: View) : BaseViewHolder(view) {
        override fun myBind(data: Data) {
            val binding = FragmentRecyclerEarthBinding.bind(itemView)
            binding.title.text = data.dataTitle
            binding.descriptionTextView.text = data.dataDescription
        }

    }

    class MarsViewHolder(view: View) : BaseViewHolder(view) {
        override fun myBind(data: Data) {
            FragmentRecyclerMarsBinding.bind(itemView).apply {
                title.text = data.dataTitle
            }

        }

    }
}
