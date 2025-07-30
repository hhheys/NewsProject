package com.example.NewsProject.controllers

import com.example.NewsProject.dto.UserDto
import com.example.NewsProject.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/create")
    fun createUser(@RequestBody userDto: UserDto) {
        userService.addUser(userDto)
    }
}