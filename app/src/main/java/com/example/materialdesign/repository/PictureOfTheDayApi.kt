package com.example.materialdesign.repository

import com.example.materialdesign.utils.KEY_NASA_DOMAIN_ENDPOINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface PictureOfTheDayApi {

    @GET(KEY_NASA_DOMAIN_ENDPOINT)

    fun getPictureOfTheDay(
        @Query("date") date: String,
        @Query("api_key") apiKey: String
    ): Call<PictureOfTheDayResponseData>
}