package com.example.navegation.data.model.user

import java.io.Serializable

data class AddressResponse(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoResponse
): Serializable
