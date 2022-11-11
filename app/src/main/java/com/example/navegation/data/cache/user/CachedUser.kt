package com.example.navegation.data.cache.user

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class CachedUser(
    @PrimaryKey                     val id: Long,
    @ColumnInfo(name = "name")      val name: String,
    @ColumnInfo(name = "username")  val username: String,
    @ColumnInfo(name = "email")     val email: String,
    @ColumnInfo(name = "phone")     val phone: String,
    @ColumnInfo(name = "website")   val website: String,
)
