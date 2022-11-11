package com.example.navegation.data.remote

import com.example.navegation.data.model.album.AlbumResponse
import com.example.navegation.data.model.photo.PhotoResponse
import com.example.navegation.data.model.user.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUsers(): Response<List<UserResponse>>

    @GET("albums")
    suspend fun getAlbums(): Response<List<AlbumResponse>>

    @GET("photos")
    suspend fun getPhotos(): Response<List<PhotoResponse>>
}