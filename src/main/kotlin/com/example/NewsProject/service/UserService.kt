package com.example.NewsProject.service

import com.example.NewsProject.dto.UserDto
import com.example.NewsProject.entity.UserEntity
import java.util.UUID

interface UserService {
    fun addUser(user: UserDto)
    fun findById(id: UUID): UserEntity
}