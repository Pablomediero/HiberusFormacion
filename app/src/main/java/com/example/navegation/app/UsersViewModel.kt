package com.example.navegation.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navegation.app.common.ResourceState
import com.example.navegation.domain.GetUsersUseCase
import com.example.navegation.model.user.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val usersLiveData: MutableLiveData<ResourceState<List<User>>> = MutableLiveData()
    fun getUsersLiveData(): LiveData<ResourceState<List<User>>> = usersLiveData

    fun getUsers(){
        usersLiveData.value = ResourceState.Loading()
        CoroutineScope(Dispatchers.Main).launch {
            usersLiveData.value = getUsersUseCase.execute()
        }
    }
}

@Suppress("UNCHECKED_CAST")
class UsersViewModelFactory (private val getUsersUseCase: GetUsersUseCase) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (UsersViewModel(getUsersUseCase) as T)
}