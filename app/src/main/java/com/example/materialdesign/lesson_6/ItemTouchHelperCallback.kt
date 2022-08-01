package com.example.materialdesign.lesson_6

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemTouchHelperCallback(private var adapter: RecyclerAdapter) :
    ItemTouchHelper.Callback() {

    interface ItemTouchHelperAdapter {
        fun onItemMove(fromPosition: Int, toPosition: Int)
        fun onItemDismiss(position: Int)
    }

    interface ItemTouchHelperViewHolder {
        fun onItemSelected()
        fun onItemClear()
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val swipeFlag = ItemTouchHelper.START or ItemTouchHelper.END
        val dragFlag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        return makeMovementFlags(dragFlag, swipeFlag)

    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true

    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.onItemDismiss(viewHolder.adapterPosition)
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        when (viewHolder) {
            is RecyclerAdapter.MarsViewHolder -> {
                viewHolder.onItemSelected()
            }
            is RecyclerAdapter.EarthViewHolder -> {
                viewHolder.onItemSelected()
            }
            else -> {

            }
        }


        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        when (viewHolder) {
            is RecyclerAdapter.MarsViewHolder -> {
                viewHolder.onItemClear()
            }
            is RecyclerAdapter.EarthViewHolder -> {
                viewHolder.onItemClear()
            }
            else -> {

            }
        }

        super.clearView(recyclerView, viewHolder)
    }

}
