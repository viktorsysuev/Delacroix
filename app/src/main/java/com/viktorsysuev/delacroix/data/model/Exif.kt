package com.viktorsysuev.delacroix.data.model

import com.squareup.moshi.Json

data class Exif(
    @Json(name = "make") val make: String?,
    @Json(name = "model") val model: String?,
    @Json(name = "exposure_time") val exposureTime: String?,
    @Json(name = "aperture") val aperture: Double?,
    @Json(name = "focal_length") val focalLength: Double?,
    @Json(name = "iso") val iso: Int?
)