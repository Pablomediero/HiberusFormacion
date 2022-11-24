package com.example.navegation.domain

import com.example.navegation.app.common.ResourceState
import com.example.navegation.data.DataRepository
import com.example.navegation.model.user.User

class GetUsersUseCase(private val dataRepository: DataRepository) {

    suspend fun execute(): ResourceState<List<User>> {
        return dataRepository.getUsers()
    }
}