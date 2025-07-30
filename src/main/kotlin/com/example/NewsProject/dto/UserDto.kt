package com.example.NewsProject.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val name: String,
    val password: String,
    val email: String,
    val role: String,
)
