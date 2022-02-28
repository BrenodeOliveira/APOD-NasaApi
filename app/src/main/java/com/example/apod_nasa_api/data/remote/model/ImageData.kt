package com.example.apod_nasa_api.data.remote.model

import com.example.apod_nasa_api.domain.model.ImageModel
import com.google.gson.annotations.SerializedName

data class ImageData(
    @SerializedName("copyright") val copyright: String?,
    @SerializedName("date") val date: String?,
    @SerializedName("explanation") val explanation: String?,
    @SerializedName("hdurl") val hdurl: String?,
    @SerializedName("media_type") val mediaType: String?,
    @SerializedName("service_version") val serviceVersion: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("url") val url: String?,
)

fun ImageData.toModel(): ImageModel {
    return ImageModel(
        this.copyright.orEmpty(),
        this.date.orEmpty(),
        this.explanation.orEmpty(),
        this.hdurl.orEmpty(),
        this.mediaType.orEmpty(),
        this.serviceVersion.orEmpty(),
        this.title.orEmpty(),
        this.url.orEmpty(),
    )
}
