package com.example.NewsProject.controllers

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dto.AccountDto
import com.example.NewsProject.service.PublisherServiceImpl
import com.example.NewsProject.service.UserServiceImpl
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/account")
class AccountController(
    private val publisherService: PublisherServiceImpl,
    private val userService: UserServiceImpl
) {
    @PostMapping("/register")
    fun createAccount(@RequestBody accountDto: AccountDto): Any {
        if (accountDto.accountType == AccountTypes.USER) {
            return userService.addUser(accountDto)
        } else if (accountDto.accountType == AccountTypes.PUBLISHER) {
            return publisherService.addPublisher(accountDto)
        }
        return "error"
    }
}