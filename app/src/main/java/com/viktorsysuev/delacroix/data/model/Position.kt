package com.viktorsysuev.delacroix.data.model

import com.squareup.moshi.Json

data class Position(
    @Json(name = "latitude") val latitude: Double?,
    @Json(name = "longitude") val longitude: Double?
)