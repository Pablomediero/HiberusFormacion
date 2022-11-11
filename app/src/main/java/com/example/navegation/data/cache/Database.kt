package com.example.navegation.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.navegation.data.cache.album.AlbumDao
import com.example.navegation.data.cache.album.CachedAlbum
import com.example.navegation.data.cache.photo.CachedPhoto
import com.example.navegation.data.cache.photo.PhotoDao
import com.example.navegation.data.cache.user.CachedAddress
import com.example.navegation.data.cache.user.CachedCompany
import com.example.navegation.data.cache.user.CachedGeo
import com.example.navegation.data.cache.user.CachedUser
import com.example.navegation.data.cache.user.UserDao

@Database(
    entities = [CachedUser::class,CachedAddress::class,CachedGeo::class,CachedCompany::class,CachedAlbum::class,CachedPhoto::class],
    /*entities = [CachedUser::class],*/
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun userDao():  UserDao
    abstract fun albumDao(): AlbumDao
    abstract fun photoDao(): PhotoDao

}