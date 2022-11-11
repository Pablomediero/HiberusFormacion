package com.example.navegation.data.cache.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "address")
data class CachedAddress(
    @PrimaryKey                         val idUser: Long,
    @ColumnInfo(name = "street")        val street: String,
    @ColumnInfo(name = "suite")         val suite: String,
    @ColumnInfo(name = "city")          val city: String,
    @ColumnInfo(name = "zipcode")       val zipcode: String,
)
