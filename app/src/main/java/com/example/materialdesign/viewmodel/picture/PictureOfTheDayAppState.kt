package com.example.materialdesign.viewmodel.picture

import com.example.materialdesign.repository.PictureOfTheDayResponseData

sealed class PictureOfTheDayAppState{
    data class Success (val pictureOfTheDayResponseData: PictureOfTheDayResponseData): PictureOfTheDayAppState()
    data class Error (val error: Throwable): PictureOfTheDayAppState()
    object Loading : PictureOfTheDayAppState()
}
