package com.example.NewsProject.dto

import kotlinx.serialization.Serializable

@Serializable
data class AccountDto(
    val name: String,
    val password: String,
    val email: String,
    val legalName: String? = null,
    val legalAddress: String? = null,
    val accountType: String,
)
