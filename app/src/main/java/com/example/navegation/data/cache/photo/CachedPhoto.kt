package com.example.navegation.data.cache.photo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class CachedPhoto(
    @ColumnInfo(name = "albumID")       val albumID: Long,
    @PrimaryKey                         val id: Long,
    @ColumnInfo(name = "title")         val title: String,
    @ColumnInfo(name = "url")           val url: String,
    @ColumnInfo(name = "thumbnailURL")  val thumbnailURL: String
)
