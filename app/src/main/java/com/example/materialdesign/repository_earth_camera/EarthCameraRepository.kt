package com.example.materialdesign.repository_earth_camera

import com.example.materialdesign.viewmodel_earth.EarthCameraViewModel

interface EarthCameraRepository {
    fun getPictureOfTheEarth(callback: EarthCameraViewModel.Callback)
}
