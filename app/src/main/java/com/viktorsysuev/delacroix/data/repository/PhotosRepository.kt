package com.viktorsysuev.delacroix.data.repository

import com.viktorsysuev.delacroix.data.model.Photo

interface PhotosRepository {

    suspend fun getPopularPhotos(): List<Photo>
}