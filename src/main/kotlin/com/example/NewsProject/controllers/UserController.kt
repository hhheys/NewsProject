package com.example.NewsProject.controllers

import com.example.NewsProject.dto.UserDto
import com.example.NewsProject.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun createUser(@RequestBody userDto: UserDto) {
        userService.addUser(userDto)
    }
}