package com.example.NewsProject.controllers

import com.example.NewsProject.dto.UserDto
import com.example.NewsProject.response.UserResponse
import com.example.NewsProject.service.UserServiceImpl
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserServiceImpl
) {
    @PostMapping("/create")
    fun createUser(@RequestBody @Valid userDto: UserDto): UserResponse {
        return userService.addUser(userDto)
    }
}