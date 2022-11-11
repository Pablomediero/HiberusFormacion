package com.example.navegation.data.model.user

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class CompanyResponse (
    val name: String,
    @SerializedName("catchPhrase") val catchPhrase: String = "",
    val bs: String
): Serializable