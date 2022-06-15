package com.example.materialdesign.repository

import com.example.materialdesign.viewmodel.picture.PictureOfTheDayViewModel

interface PictureOfTheDayRepository {
    fun getPictureOfTheDay(date: String, callback: PictureOfTheDayViewModel.Callback)
}
