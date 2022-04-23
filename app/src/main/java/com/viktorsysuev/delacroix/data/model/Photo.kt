package com.viktorsysuev.delacroix.data.model

import com.squareup.moshi.Json

data class Photo(
    @Json(name = "id") val id: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    @Json(name = "width") val width: Int,
    @Json(name = "height") val height: Int,
    @Json(name = "color") val color: String,
    @Json(name = "blur_hash") val blurHash: String,
    @Json(name = "downloads") val downloads: Int?,
    @Json(name = "likes") val likes: Int,
    @Json(name = "liked_by_user") val likedByUser: Boolean,
    @Json(name = "description") val description: String?,
    @Json(name = "exif") val exif: Exif?,
    @Json(name = "location") val location: Location?,
    @Json(name = "current_user_collections") val currentUserCollections: List<CurrentUserCollections>?,
    @Json(name = "urls") val urls: Urls?,
    @Json(name = "links") val links: Links?,
    @Json(name = "user") val user: User?
) {

}