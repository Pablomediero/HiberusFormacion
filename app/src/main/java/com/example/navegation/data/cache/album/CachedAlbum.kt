package com.example.navegation.data.cache.album

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album")
data class CachedAlbum(
    @ColumnInfo(name = "userId")    val userId: Long,
    @PrimaryKey    val id: Long,
    @ColumnInfo(name = "title") val title: String,
)
