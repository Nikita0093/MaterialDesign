package com.example.materialdesign.repository

import com.example.materialdesign.viewmodel.picture.PictureOfTheDayViewModel

interface PictureOfTheDayRepository {
    fun getPictureOfTheDay(callback: PictureOfTheDayViewModel.Callback)
}
