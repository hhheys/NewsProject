package com.example.NewsProject.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import kotlinx.serialization.Serializable

@Serializable
data class AccountDto(
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    val name: String,
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 6, message = "Password should be at least 6 characters long")
    val password: String,
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    val email: String,
    @NotEmpty(message = "Legal name should not be empty")
    @Size(min = 2, message = "Legal name should be at least 2 characters long")
    val legalName: String,
    @NotEmpty(message = "Legal address should not be empty")
    @Size(min = 2, message = "Legal address should be at least 2 characters long")
    val legalAddress: String,
    @NotEmpty(message = "Account type should not be empty")
    val accountType: String,
)
