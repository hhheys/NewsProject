package com.example.NewsProject.dto

import com.example.NewsProject.dto.kafka.CommentEvent
import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

data class CreateCommentDto (
    @Schema(description = "UUID поста")
    val postUUID: UUID,
    @Schema(description = "Содержание комментария")
    val content: String
) {
    constructor(comment: CommentEvent): this(
        postUUID = comment.postUUID,
        content = comment.content
    )
}