package com.example.NewsProject.dto

import java.util.UUID

data class PostReactionDto (
    val postUUID: UUID,
    val type: String
)