package com.example.NewsProject.dto

import io.swagger.v3.oas.annotations.media.Schema

data class PostCreateDto (
    @Schema(description = "Название поста")
    val title: String,
    @Schema(description = "Описание поста")
    val description: String,
    @Schema(description = "Основное содержимое поста")
    val content: String,
    @Schema(description = "Список ID топиков")
    val topicIDList: List<Int>
)