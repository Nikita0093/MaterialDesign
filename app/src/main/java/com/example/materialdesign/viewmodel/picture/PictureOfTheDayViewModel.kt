package com.example.materialdesign.viewmodel.picture

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.materialdesign.BuildConfig
import com.example.materialdesign.repository.PictureOfTheDayResponseData
import com.example.materialdesign.repository.PictureOfTheDayRetrofitImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val liveData: MutableLiveData<PictureOfTheDayAppState> = MutableLiveData(),
    private val pictureOfTheDayRetrofitImpl: PictureOfTheDayRetrofitImpl = PictureOfTheDayRetrofitImpl()
) : ViewModel() {
    val pictureOfTheDayFragment = PictureOfTheDayFragment()

    fun getLiveData(): LiveData<PictureOfTheDayAppState> {
        return liveData
    }


    fun sendRequest() {
        liveData.postValue(PictureOfTheDayAppState.Loading(null))
        pictureOfTheDayRetrofitImpl.getRetrofit()
            .getPictureOfTheDay(BuildConfig.NASA_API_KEY)
            .enqueue(callback)
    }

    private val callback = object : Callback<PictureOfTheDayResponseData> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    liveData.postValue(PictureOfTheDayAppState.Success(it))
                }
            } else {
                Toast.makeText(
                    pictureOfTheDayFragment.requireContext(),
                    "Ошибка: $response",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            liveData.postValue(PictureOfTheDayAppState.Error(t))
        }

    }
}
