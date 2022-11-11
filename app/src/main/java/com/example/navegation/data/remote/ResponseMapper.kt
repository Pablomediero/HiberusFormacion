package com.example.navegation.data.remote

import com.example.navegation.data.model.album.AlbumResponse
import com.example.navegation.data.model.photo.PhotoResponse
import com.example.navegation.data.model.user.AddressResponse
import com.example.navegation.data.model.user.CompanyResponse
import com.example.navegation.data.model.user.GeoResponse
import com.example.navegation.data.model.user.UserResponse
import com.example.navegation.data.util.orDefault
import com.example.navegation.model.photo.Photo
import com.example.navegation.model.album.Album
import com.example.navegation.model.user.Address
import com.example.navegation.model.user.Company
import com.example.navegation.model.user.Geo
import com.example.navegation.model.user.User

open class ResponseMapper {

    fun mapFromRemote(type: UserResponse, type2: List<AlbumResponse>, type3: List<List<PhotoResponse>>): User {
        return User(
            type.id,
            type.name,
            type.username,
            type.email,
            mapFromRemote(type.address),
            type.phone,
            type.website,
            mapFromRemote(type.company),
            mapFromRemote(type2, type3)
        )
    }

    fun mapFromRemote(type: AddressResponse): Address {
        return Address(
            type.street,
            type.suite,
            type.city,
            type.zipcode,
            mapFromRemote(type.geo)
        )
    }

    fun mapFromRemote(type: CompanyResponse): Company {
        return Company(
            type.name,
            type.catchPhrase.orDefault(),
            type.bs
        )
    }

    fun mapFromRemote(type: GeoResponse): Geo {
        return Geo(
            type.lat,
            type.lng
        )
    }

    fun mapFromRemote(type: AlbumResponse, type3: List<PhotoResponse>): Album {
        return Album(
            type.userId,
            type.id,
            type.title,
            type3.map{photoResponse ->
                mapFromRemote(photoResponse)
            }
        )
    }

    fun mapFromRemote(type: PhotoResponse): Photo {
        return Photo(
            type.albumID,
            type.id,
            type.title,
            type.url,
            type.thumbnailURL

            )
    }

    fun mapFromRemote(type1: List<AlbumResponse>, type2: List<List<PhotoResponse>>): List<Album>{
        val listAlbums = mutableListOf<Album>()
         type1.forEachIndexed { index, albumResponse ->
            listAlbums.add(mapFromRemote(albumResponse, type2[index]))
        }
        return listAlbums
    }

}