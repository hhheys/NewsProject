package com.example.NewsProject.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class PostReactionDto (
    @Schema(description = "UUID поста")
    val postUUID: UUID,
    @Schema(description = "Тип (like/dislike)")
    val type: String
)