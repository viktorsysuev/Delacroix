package com.viktorsysuev.delacroix.data.repository

import com.viktorsysuev.delacroix.data.api.UpsplashService
import com.viktorsysuev.delacroix.data.model.Photo

class PhotosRepositoryImpl(private val service: UpsplashService) : PhotosRepository {

    override suspend fun getRandomPhoto(): Photo {
        return service.getRandomPhoto()
    }
}