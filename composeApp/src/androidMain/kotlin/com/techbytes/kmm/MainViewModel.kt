package com.techbytes.kmm;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import api.HomeRepository
import data.RandomUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = HomeRepository()

    private val _users = MutableStateFlow<List<RandomUser>>(listOf())
    val users = _users.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getUsers().collect { users ->
                _users.update {
                    it+users
                }
            }
        }
    }


}