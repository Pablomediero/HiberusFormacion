package com.example.navegation.model.album

import com.example.navegation.model.photo.Photo
import java.io.Serializable

data class Album(
    val userId: Long,
    val id: Long,
    val title: String,
    val photos: List<Photo>
): Serializable
