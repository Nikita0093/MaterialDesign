package com.example.materialdesign.viewmodel.picture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.materialdesign.repository_picture_of_the_day.PictureOfTheDayRepository
import com.example.materialdesign.repository_picture_of_the_day.PictureOfTheDayResponseData
import com.example.materialdesign.repository_picture_of_the_day.PictureOfTheDayRetrofitImpl

class PictureOfTheDayViewModel(
    private val liveData: MutableLiveData<PictureOfTheDayAppState> = MutableLiveData(),
    private var pictureOfTheDayRepository: PictureOfTheDayRepository = PictureOfTheDayRetrofitImpl()
) : ViewModel() {

    fun getLiveData(): LiveData<PictureOfTheDayAppState> {
        return liveData
    }


    fun getPictureOfTheDayByViewModel(date:String) {
        liveData.postValue(PictureOfTheDayAppState.Loading)
        pictureOfTheDayRepository.getPictureOfTheDay(date,object : Callback {
            override fun onResponse(pictureOfTheDayResponseData: PictureOfTheDayResponseData) {
                liveData.postValue(PictureOfTheDayAppState.Success(pictureOfTheDayResponseData))
            }

            override fun onFailure(e: Throwable) {
                liveData.postValue(PictureOfTheDayAppState.Error(e))
            }

        })


    }


    interface Callback {

        fun onResponse(pictureOfTheDayResponseData: PictureOfTheDayResponseData)

        fun onFailure(e: Throwable)
    }
}
