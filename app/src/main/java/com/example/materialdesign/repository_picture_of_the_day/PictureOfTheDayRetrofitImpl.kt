package com.example.materialdesign.repository_picture_of_the_day

import com.example.materialdesign.BuildConfig
import com.example.materialdesign.repository_earth_camera.EarthCameraApi
import com.example.materialdesign.repository_earth_camera.EarthCameraRepository
import com.example.materialdesign.repository_earth_camera.EarthCameraResponseData
import com.example.materialdesign.utils.KEY_NASA_DOMAIN_BASE_URL
import com.example.materialdesign.viewmodel.picture.PictureOfTheDayViewModel
import com.example.materialdesign.viewmodel_earth.EarthCameraViewModel
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PictureOfTheDayRetrofitImpl : PictureOfTheDayRepository, EarthCameraRepository {
    private val nasaBaseUrl = KEY_NASA_DOMAIN_BASE_URL


    override fun getPictureOfTheDay(date: String, callback: PictureOfTheDayViewModel.Callback) {


        val pictureOfTheDayApi = Retrofit.Builder()
            .baseUrl(nasaBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(PictureOfTheDayApi::class.java)
        pictureOfTheDayApi.getPictureOfTheDay(date, BuildConfig.NASA_API_KEY)
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

    override fun getPictureOfTheEarth(callback: EarthCameraViewModel.Callback) {


        val pictureOfTheEarth = Retrofit.Builder()
            .baseUrl(nasaBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build().create(EarthCameraApi::class.java)
        pictureOfTheEarth.getEarthPicture(BuildConfig.NASA_API_KEY)
            .enqueue(object : Callback<List<EarthCameraResponseData>> {
                override fun onResponse(
                    call: Call<List<EarthCameraResponseData>>,
                    response: Response<List<EarthCameraResponseData>>
                ) {
                    callback.onResponse(response.body()!!)
                }

                override fun onFailure(call: Call<List<EarthCameraResponseData>>, t: Throwable) {
                    callback.onFailure(t)
                }


            })

    }


}