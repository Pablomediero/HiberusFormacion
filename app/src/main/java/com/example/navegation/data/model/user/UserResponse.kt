package com.example.navegation.data.model.user


import java.io.Serializable

data class UserResponse (
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressResponse,
    val phone: String,
    val website: String,
    val company: CompanyResponse
): Serializable




