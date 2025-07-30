package com.example.NewsProject.service

import com.example.NewsProject.dto.UserDto

interface UserService {
    fun addUser(user: UserDto)
}