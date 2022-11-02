package com.example.navegation


import java.io.Serializable

data class Receta(
    val nombre: String,
    val ingredientes: List<String>,
    val informacion: String,
    val elaboracion: String,
    val fotoUrl: String,
): Serializable
