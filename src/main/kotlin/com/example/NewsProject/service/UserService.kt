package com.example.NewsProject.service

import com.example.NewsProject.dto.UserDto
import com.example.NewsProject.entity.UserEntity
import com.example.NewsProject.response.UserResponse
import java.util.UUID

interface UserService {
    fun addUser(user: UserDto): UserResponse
    fun findById(id: UUID): UserEntity
}