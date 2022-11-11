package com.example.navegation.model.user


import com.example.navegation.model.album.Album
import java.io.Serializable

data class User (
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
    val albums : List<Album>,

): Serializable




