package com.example.NewsProject.service

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dao.UserRepository
import com.example.NewsProject.dto.AccountDto
import com.example.NewsProject.entity.UserEntity
import com.example.NewsProject.response.UserResponse
import jakarta.transaction.Transactional
import org.apache.coyote.BadRequestException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
): UserService {

    @Transactional
    override fun addUser(user: AccountDto): UserResponse {
        val userEntity = UserEntity().apply {
            this.name = user.name
            this.password = passwordEncoder.encode(user.password)
            this.email = user.email
            this.accountType = AccountTypes.USER
        }
        try {
            userRepository.save(userEntity)
          return UserResponse(userEntity)
        } catch (_: Exception){
            throw BadRequestException("Failed to create account")
        }
    }

    @Transactional
    override fun findById(id: UUID): UserEntity {
        val optionalUser = userRepository.findById(id)
        if (optionalUser.isPresent){
            return optionalUser.get()
        }
        print("not found ${id.toString()}")
        throw BadRequestException("User not found")
    }
}