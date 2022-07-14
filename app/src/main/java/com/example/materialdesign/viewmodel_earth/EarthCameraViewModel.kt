package com.example.materialdesign.viewmodel_earth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.materialdesign.repository_earth_camera.EarthCameraRepository
import com.example.materialdesign.repository_earth_camera.EarthCameraResponseData
import com.example.materialdesign.repository_picture_of_the_day.PictureOfTheDayRetrofitImpl

class EarthCameraViewModel(
    private val liveData: MutableLiveData<EarthCameraAppState> = MutableLiveData(),
    private var pictureOfEarth: EarthCameraRepository = PictureOfTheDayRetrofitImpl()
) : ViewModel() {

    fun getLiveData(): LiveData<EarthCameraAppState> {
        return liveData
    }


    fun getEarthPictureByViewModel() {
        //liveData.postValue(EarthCameraAppState.Loading)
        pictureOfEarth.getPictureOfTheEarth(object : Callback {
            override fun onResponse(pictureOfEarth: List<EarthCameraResponseData>) {
                val randomIndex = (0..10).random()
                liveData.postValue(EarthCameraAppState.Success(pictureOfEarth[randomIndex]))
            }

            override fun onFailure(e: Throwable) {
                liveData.postValue(EarthCameraAppState.Error(e))
            }
        })
    }


    interface Callback {

        fun onResponse(pictureOfEarth: List<EarthCameraResponseData>)

        fun onFailure(e: Throwable)
    }
}
