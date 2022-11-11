package com.example.navegation.data.cache.photo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDao {
    @Insert
    suspend fun insertPhoto(cachedPhoto: CachedPhoto)

    @Query("Select * from photo WHERE albumId = :albumId")
    suspend fun getPhotosByAlbumId(albumId: Long): List<CachedPhoto>

    @Query("Select * from photo")
    suspend fun getAllPhoto(): List<CachedPhoto>
}