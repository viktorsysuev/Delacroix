package com.viktorsysuev.delacroix.data.model

import com.squareup.moshi.Json


data class ProfileLinks(
    @Json(name = "small") val small: String,
    @Json(name = "medium") val medium: String,
    @Json(name = "large") val large: String?
)