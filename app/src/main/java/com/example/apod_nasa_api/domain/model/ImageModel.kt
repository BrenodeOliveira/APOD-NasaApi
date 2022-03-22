package com.example.apod_nasa_api.domain.model

import com.example.apod_nasa_api.presentation.viewobject.ImageViewObject

data class ImageModel(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: String,
    val serviceVersion: String,
    val title: String,
    val url: String,
)

fun ImageModel.toVO(): ImageViewObject {
    return ImageViewObject(
        this.copyright,
        this.date,
        this.hdurl,
        this.explanation,
        this.title,
    )
}