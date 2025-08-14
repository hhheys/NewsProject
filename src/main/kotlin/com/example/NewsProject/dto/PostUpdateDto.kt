package com.example.NewsProject.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class PostUpdateDto (
    @Schema(description = "Название поста")
    val title: String? = null,
    @Schema(description = "Описание поста")
    val description: String? = null,
    @Schema(description = "Основное содержимое поста")
    val content: String? = null,
    @Schema(description = "Список ID топиков")
    val topicIDList: List<Int>? = null,
    val publisherUUID: UUID? = null
)