package com.example.navegation.data.model.album

import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("userId")
    val userId: Long,
    val id: Long,
    val title: String
)
