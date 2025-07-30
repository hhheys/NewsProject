package com.example.NewsProject.service

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dao.UserRepository
import com.example.NewsProject.dto.UserDto
import com.example.NewsProject.entity.UserEntity
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {
    override fun addUser(user: UserDto) {
        val userEntity = UserEntity().apply {
            this.name = user.name
            this.password = user.password
            this.email = user.password
            this.role = user.role
            this.accountType = AccountTypes.USER
        }
    }
}