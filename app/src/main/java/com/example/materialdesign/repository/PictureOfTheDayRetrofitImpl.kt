package com.example.materialdesign.repository

import com.example.materialdesign.utils.KEY_NASA_DOMAIN_BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PictureOfTheDayRetrofitImpl {
    private val nasaBaseUrl = KEY_NASA_DOMAIN_BASE_URL

    fun getRetrofit(): PictureOfTheDayApi {
        val pictureOfTheDayRetrofit = Retrofit.Builder()
            .baseUrl(nasaBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
        return pictureOfTheDayRetrofit.create(PictureOfTheDayApi::class.java)

    }
}