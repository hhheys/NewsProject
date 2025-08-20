package com.example.NewsProject.controllers

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dto.AccountDto
import com.example.NewsProject.handlers.exceptions.BadRequestException
import com.example.NewsProject.response.PublisherResponse
import com.example.NewsProject.response.UserResponse
import com.example.NewsProject.service.PublisherServiceImpl
import com.example.NewsProject.service.UserServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/account")
@Tag(name = "Account", description = "Логика взаимодействия с аккаунтами.")
class AccountController(
    private val publisherService: PublisherServiceImpl,
    private val userService: UserServiceImpl
) {
    @PostMapping("/register")
    @Operation(summary = "Регистрация пользователя.")
    fun createAccount(@RequestBody accountDto: AccountDto): Any {
        if (accountDto.accountType == AccountTypes.USER_FOR_REGISTRATION) {
            return userService.addUser(accountDto)
        } else if (accountDto.accountType == AccountTypes.PUBLISHER) {
            return publisherService.addPublisher(accountDto)
        }
        return BadRequestException("Failed to create account. Incorrect data entered")
    }

    @GetMapping("/users")
    @Operation(summary = "Получение всех пользователей.")
    fun getAllUsers(): List<UserResponse> {
        return userService.findAllUsers()
    }

    @GetMapping("/publishers")
    @Operation(summary = "Получение всех издателей.")
    fun getAllPublishers(): List<PublisherResponse> {
        return publisherService.findAllPublishers()
    }
}