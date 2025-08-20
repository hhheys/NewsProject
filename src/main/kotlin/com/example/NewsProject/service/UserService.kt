package com.example.NewsProject.service

import com.example.NewsProject.dto.AccountDto
import com.example.NewsProject.entity.UserEntity
import com.example.NewsProject.response.UserResponse
import java.util.UUID

interface UserService {
    fun addUser(user: AccountDto): UserResponse
    fun findById(id: UUID): UserEntity
    fun findAllUsers(): List<UserResponse>
}