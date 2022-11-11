package com.example.navegation.data.cache.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class CachedCompany(
    @PrimaryKey                         val idUser: Long,
    @ColumnInfo(name = "name")          val name: String,
    @ColumnInfo(name = "catchPhrase")   val catchPhrase: String,
    @ColumnInfo(name = "bs")            val bs: String
)
