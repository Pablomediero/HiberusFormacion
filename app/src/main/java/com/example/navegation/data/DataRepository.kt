package com.example.navegation.data

import android.content.Context
import android.util.Log
import com.example.navegation.app.common.ResourceState
import com.example.navegation.data.cache.CacheMapper
import com.example.navegation.data.model.album.AlbumResponse
import com.example.navegation.data.model.photo.PhotoResponse
import com.example.navegation.data.model.user.UserResponse
import com.example.navegation.data.remote.ResponseMapper
import com.example.navegation.data.remote.UserService
import com.example.navegation.data.remote.UserServiceFactory
import com.example.navegation.data.cache.DatabaseBuilder
import com.example.navegation.model.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class DataRepository(context: Context) {
    private val userService: UserService = UserServiceFactory.makeTrazaService()
    private val responseMapper: ResponseMapper = ResponseMapper()
    private val cacheMapper: CacheMapper = CacheMapper()
    private val database = DatabaseBuilder.getInstance(context)


    suspend fun getUsers(): ResourceState<List<User>> = withContext(Dispatchers.IO) {
        if (database.userDao().getAllUser().isEmpty()) {
            return@withContext try {
                val callUsers = async { userService.getUsers() }
                val callAlbums = async { userService.getAlbums() }
                val callPhotos = async { userService.getPhotos() }
                if ((callUsers.await().isSuccessful) && (callAlbums.await().isSuccessful) && (callPhotos.await().isSuccessful)) {
                    val usersResponse = callUsers.await().body() as List<UserResponse>
                    val albumsResponse = callAlbums.await().body() as List<AlbumResponse>
                    val photosResponse = callPhotos.await().body() as List<PhotoResponse>

                    val userList = usersResponse.map { userResponse ->
                        val albumsResponseForUser = albumsResponse.filter { album ->
                            userResponse.id == album.userId
                        }
                        val photosResponseForUser = albumsResponseForUser.map { album ->
                            photosResponse.filter { photo ->
                                album.id == photo.albumID
                            }
                        }
                        responseMapper.mapFromRemote(
                            userResponse,
                            albumsResponseForUser,
                            photosResponseForUser
                        )
                    }
                    userList.forEach { user ->
                        database.userDao()
                            .insertUser(cacheMapper.mapToCached(user))
                        database.userDao()
                            .insertAddress(cacheMapper.mapToCached(user.address, user))
                        database.userDao()
                            .insertGeo(cacheMapper.mapToCached(user.address.geo, user))
                        database.userDao()
                            .insertCompany(cacheMapper.mapToCached(user.company, user))

                        user.albums.forEach{album ->
                            database.albumDao().insertAlbum(cacheMapper.mapToCached(album))
                            album.photos.forEach{photo ->
                                database.photoDao().insertPhoto(cacheMapper.mapToCached(photo))
                            }
                        }
                    }

                    ResourceState.Success(userList)
                } else {
                    ResourceState.Success(emptyList())

                }
            } catch (e: Exception) {
                Log.e("Throwable Data Repository", e.toString())
                ResourceState.Error(e.message!!)
            }
        } else {
            val userL = database.userDao().getAllUser().map { cachedUser ->
                val address = async {
                    val geo = cacheMapper.mapFromCached(database.userDao().getGeo(cachedUser.id))
                    cacheMapper.mapFromCached(database.userDao().getAddress(cachedUser.id), geo)
                }.await()

                val company = async {
                        cacheMapper.mapFromCached(database.userDao().getCompany(cachedUser.id))
                }.await()

                val albums = async {
                    database.albumDao().getAllAlbum().map{ cachedAlbum ->
                        val photos =
                            database.photoDao().getPhotosByAlbumId(cachedAlbum.id)
                        cacheMapper.mapFromCached( cachedAlbum ,photos)
                        }
                }.await()
                cacheMapper.mapFromCached(cachedUser, address, company, albums)
            }

            ResourceState.Success(userL)
        }

    }
}