package com.example.NewsProject.dto

import io.swagger.v3.oas.annotations.media.Schema
import kotlinx.serialization.Serializable

@Serializable
data class AccountDto(
    @Schema(description = "Никнейм аккаунта")
    val name: String,
    @Schema(description = "Пароль аккаунта")
    val password: String,
    @Schema(description = "Email аккаунта")
    val email: String,
    @Schema(description = "Юридическое название (если тип аккаунта 'publisher')")
    val legalName: String? = null,
    @Schema(description = "Юридический адрес (если тип аккаунта 'publisher')")
    val legalAddress: String? = null,
    @Schema(description = "Тип аккаунта - \"user_entity\" / \"publisher\"")
    val accountType: String,
)
