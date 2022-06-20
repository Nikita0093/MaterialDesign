package com.example.materialdesign.repository_picture_of_the_day

import com.example.materialdesign.viewmodel.picture.PictureOfTheDayViewModel

interface PictureOfTheDayRepository {
    fun getPictureOfTheDay(date: String, callback: PictureOfTheDayViewModel.Callback)
}
