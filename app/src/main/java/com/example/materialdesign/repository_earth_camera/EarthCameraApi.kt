package com.example.materialdesign.repository_earth_camera

import com.example.materialdesign.utils.KEY_EPIC_ENDPOINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EarthCameraApi {

    @GET (KEY_EPIC_ENDPOINT)

    fun getEarthPicture(
        @Query ("api_key") apikey: String
    ): Call <List<EarthCameraResponseData>>
}