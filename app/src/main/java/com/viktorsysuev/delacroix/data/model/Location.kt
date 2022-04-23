package com.viktorsysuev.delacroix.data.model

import com.squareup.moshi.Json

data class Location(
    @Json(name = "name") val name: String?,
    @Json(name = "city") val city: String?,
    @Json(name = "country") val country: String?,
    @Json(name = "position") val position: Position?
)