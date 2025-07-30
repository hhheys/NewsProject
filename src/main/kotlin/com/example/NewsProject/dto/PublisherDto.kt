package com.example.NewsProject.dto

import kotlinx.serialization.Serializable

@Serializable
data class PublisherDto(
    val name: String,
    val password: String,
    val email: String,
    val legalName: String,
    val legalAddress: String,
)
