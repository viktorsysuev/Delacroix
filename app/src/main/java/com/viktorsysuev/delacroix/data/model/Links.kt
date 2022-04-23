package com.viktorsysuev.delacroix.data.model

import com.squareup.moshi.Json


data class Links(
    @Json(name = "self") val self: String,
    @Json(name = "html") val html: String,
    @Json(name = "photos") val photos: String?,
    @Json(name = "likes") val likes: String?,
    @Json(name = "portfolio") val portfolio: String?
)