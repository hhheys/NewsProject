package com.example.NewsProject.dto

import java.util.UUID

data class CreateCommentDto (
    val postUUID: UUID,
    val content: String
)