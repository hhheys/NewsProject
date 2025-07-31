package com.example.NewsProject.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    val name: String,
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    val password: String,
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    val email: String,
    @NotEmpty(message = "Role should not be empty")
    val role: String,
)
