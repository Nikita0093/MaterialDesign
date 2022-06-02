package com.example.materialdesign.repository

import com.example.materialdesign.BuildConfig
import com.example.materialdesign.utils.KEY_NASA_DOMAIN_BASE_URL
import com.example.materialdesign.viewmodel.picture.PictureOfTheDayViewModel
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PictureOfTheDayRetrofitImpl : PictureOfTheDayRepository {
    private val nasaBaseUrl = KEY_NASA_DOMAIN_BASE_URL


    override fun getPictureOfTheDay(callback: PictureOfTheDayViewModel.Callback) {
        val pictureOfTheDayApi = Retrofit.Builder()
            .baseUrl(nasaBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(PictureOfTheDayApi::class.java)
        pictureOfTheDayApi.getPictureOfTheDay(BuildConfig.NASA_API_KEY)
            .enqueue(object : Callback<PictureOfTheDayResponseData> {
                override fun onResponse(
                    call: Call<PictureOfTheDayResponseData>,
                    response: Response<PictureOfTheDayResponseData>
                ) {
                    if (response.isSuccessful) {
                        callback.onResponse(response.body()!!)
                    }

                }

                override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
                    callback.onFailure(t)
                }

            })

    }
}