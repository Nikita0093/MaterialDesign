package com.example.materialdesign.lesson_6

interface OnListItemClickListener {


    fun onItemClick(data: Data)
    fun onAddBtnClick(position: Int)
    fun onRemoveBtnClick(position: Int)
    fun onMoveUp(position: Int)
    fun onMoveDown(position: Int)
}
