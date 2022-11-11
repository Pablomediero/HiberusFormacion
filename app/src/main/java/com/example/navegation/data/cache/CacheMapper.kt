package com.example.navegation.data.cache

import com.example.navegation.data.cache.album.CachedAlbum
import com.example.navegation.data.cache.photo.CachedPhoto
import com.example.navegation.data.cache.user.CachedAddress
import com.example.navegation.data.cache.user.CachedCompany
import com.example.navegation.data.cache.user.CachedGeo
import com.example.navegation.data.cache.user.CachedUser
import com.example.navegation.model.album.Album
import com.example.navegation.model.photo.Photo
import com.example.navegation.model.user.Address
import com.example.navegation.model.user.Company
import com.example.navegation.model.user.Geo
import com.example.navegation.model.user.User


open class CacheMapper {
    /*********************** FROM ***********************/

    fun mapFromCached(type: CachedUser, type2: Address, type3: Company, type4: List<Album>): User {
        return User(
            type.id,
            type.name,
            type.username,
            type.email,
            type2,
            type.phone,
            type.website,
            type3,
            type4
        )
    }

    fun mapFromCached(type: CachedAddress, type2: Geo): Address {
        return Address(
            type.street,
            type.suite,
            type.city,
            type.zipcode,
            type2
        )
    }

    fun mapFromCached(type: CachedGeo): Geo {
        return Geo(
            type.lat,
            type.lng
        )
    }

    fun mapFromCached(type: CachedCompany): Company {
        return Company(
            type.name,
            type.catchPhrase,
            type.bs
        )
    }

    fun mapFromCached(type: CachedPhoto): Photo {
        return Photo(
            type.albumID,
            type.id,
            type.title,
            type.url,
            type.thumbnailURL
        )
    }

    fun mapFromCached(type: CachedAlbum, type2: List<CachedPhoto>): Album {
        return Album(
            type.userId,
            type.id,
            type.title,
            type2.map {
                mapFromCached(it)
            }
        )
    }



    fun mapFromCached(type: CachedAlbum): Album {
        return Album(
            type.userId,
            type.id,
            type.title,
            emptyList()
        )
    }

    /*********************** TO ***********************/

    fun mapToCached(type: User): CachedUser {
        return CachedUser(
            type.id,
            type.name,
            type.username,
            type.email,
            type.phone,
            type.website,
        )
    }

    fun mapToCached(type: Address, user: User): CachedAddress {
        return CachedAddress(

            user.id,
            type.street,
            type.suite,
            type.city,
            type.zipcode,
        )
    }

    fun mapToCached(type: Geo, user: User): CachedGeo {
        return CachedGeo(
            user.id,
            type.lat,
            type.lng
        )
    }

    fun mapToCached(type: Company, user: User): CachedCompany {
        return CachedCompany(
            user.id,
            type.name,
            type.catchPhrase,
            type.bs
        )
    }

    fun mapToCached(type: Photo): CachedPhoto {
        return CachedPhoto(
            type.albumID,
            type.id,
            type.title,
            type.url,
            type.thumbnailURL
        )
    }

    fun mapToCached(type: Album): CachedAlbum {
        return CachedAlbum(
            type.userId,
            type.id,
            type.title,

        )
    }
}