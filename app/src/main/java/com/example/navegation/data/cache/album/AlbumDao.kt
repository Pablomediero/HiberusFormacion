package com.example.navegation.data.cache.album

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlbumDao {
    @Insert
    suspend fun insertAlbum(cachedAlbum: CachedAlbum)

    @Query("Select * from album")
    suspend fun getAllAlbum(): List<CachedAlbum>


}