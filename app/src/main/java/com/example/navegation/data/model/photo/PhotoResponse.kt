package com.example.navegation.data.model.photo

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("albumId")
    val albumID: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailURL: String
)
