package com.example.materialdesign.viewmodel_earth

import com.example.materialdesign.repository_earth_camera.EarthCameraResponseData

sealed class EarthCameraAppState {
    data class Success(val earthCameraResponseData: EarthCameraResponseData) : EarthCameraAppState()
    data class Error(val error: Throwable) : EarthCameraAppState()
    object Loading : EarthCameraAppState()
}
