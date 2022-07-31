package com.example.materialdesign.lesson_6

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesign.databinding.FragmentRecyclerEarthBinding
import com.example.materialdesign.databinding.FragmentRecyclerMarsBinding
import com.example.materialdesign.databinding.FragmentRecyclerTitleBinding
import com.example.materialdesign.utils.TYPE_EARTH
import com.example.materialdesign.utils.TYPE_MARS
import com.example.materialdesign.utils.TYPE_TITLE

class RecyclerAdapter(private var onListItemClickListener: OnListItemClickListener) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private lateinit var list: MutableList<Pair<Data, Boolean>>

    fun setList(newList: List<Pair<Data, Boolean>>) {
        list = newList.toMutableList()
    }

    fun setAddToList(newList: List<Pair<Data, Boolean>>, position: Int) {
        list = newList.toMutableList()
        notifyItemChanged(position)
    }

    fun setRemoveToList(newList: List<Pair<Data, Boolean>>, position: Int) {
        list = newList.toMutableList()
        notifyItemRemoved(position)
    }

    fun setMoveUpList(newList: List<Pair<Data, Boolean>>, position: Int) {
        list = newList.toMutableList()
        notifyItemMoved(position, position - 1)
    }

    fun setMoveDownList(newList: List<Pair<Data, Boolean>>, position: Int) {
        list = newList.toMutableList()
        notifyItemMoved(position, position + 1)
    }


    override fun getItemViewType(position: Int): Int {
        return list[position].first.type
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

            TYPE_TITLE -> {
                val view = FragmentRecyclerTitleBinding.inflate(LayoutInflater.from(parent.context))
                return TitleViewHolder(view.root)
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


    inner class EarthViewHolder(view: View) : BaseViewHolder(view) {
        override fun myBind(data: Pair<Data, Boolean>) {
            val binding = FragmentRecyclerEarthBinding.bind(itemView)
            binding.title.text = data.first.dataTitle
            binding.descriptionTextView.text = data.first.dataDescription
        }

    }

    inner class MarsViewHolder(view: View) : BaseViewHolder(view) {
        override fun myBind(data: Pair<Data, Boolean>) {
            FragmentRecyclerMarsBinding.bind(itemView).apply {
                title.text = data.first.dataTitle
                addItemImageView.setOnClickListener {
                    onListItemClickListener.onAddBtnClick(layoutPosition)

                }
                removeItemImageView.setOnClickListener {
                    TransitionManager.beginDelayedTransition(root)
                    onListItemClickListener.onRemoveBtnClick(layoutPosition)
                }

                moveItemUp.setOnClickListener {
                    onListItemClickListener.onMoveUp(layoutPosition)


                }

                moveItemDown.setOnClickListener {
                    onListItemClickListener.onMoveDown(layoutPosition)

                }

                marsImageView.setOnClickListener {
                    list[layoutPosition] = list[layoutPosition].let {
                       it.first to !it.second
                   }
                    marsDescriptionTextView.visibility = if (list[layoutPosition].second) View.VISIBLE else View.GONE

                    notifyItemChanged(layoutPosition)
                }


            }

        }

    }

    inner class TitleViewHolder(view: View) : BaseViewHolder(view) {
        override fun myBind(data: Pair<Data, Boolean>) {
            FragmentRecyclerTitleBinding.bind(itemView).apply {
                header.text = data.first.dataTitle
            }

        }

    }
}
