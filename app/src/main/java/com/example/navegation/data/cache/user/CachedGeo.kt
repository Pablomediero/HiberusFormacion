package com.example.navegation.data.cache.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geo")
data class CachedGeo(
    @PrimaryKey               val idUser: Long,
    @ColumnInfo(name = "lat") val lat: String,
    @ColumnInfo(name = "lng") val lng: String
)
