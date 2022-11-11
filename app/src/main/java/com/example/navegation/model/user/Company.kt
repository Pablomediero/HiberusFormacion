package com.example.navegation.model.user

import java.io.Serializable


data class Company (
    val name: String,
    val catchPhrase: String = "",
    val bs: String
): Serializable