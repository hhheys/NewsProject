package com.example.NewsProject.dto

import io.swagger.v3.oas.annotations.media.Schema
import kotlinx.serialization.Serializable

@Serializable
data class TopicDto(
    @Schema(description = "Название топика")
    val name: String,
)
