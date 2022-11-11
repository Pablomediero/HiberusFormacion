package com.example.navegation.model.photo

import java.io.Serializable

data class Photo(
    val albumID: Long,
    val id: Long,
    val title: String,
    val url: String,
    val thumbnailURL: String
): Serializable
