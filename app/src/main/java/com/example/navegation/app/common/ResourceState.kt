package com.example.navegation.app.common

sealed class ResourceState<out T> {
    class Loading<T> : ResourceState<T>() // Loading can NOT be an object inside a class with a generic type
    data class Success<T>(val data: T) : ResourceState<T>()
    data class Error<T>(val errorMessage: String) : ResourceState<T>()
}
