package com.example.NewsProject.response

import com.example.NewsProject.entity.CommentEntity
import com.example.NewsProject.utils.UUIDSerializer
import io.swagger.v3.oas.annotations.media.Schema
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class CommentResponse (
    @Serializable(with = UUIDSerializer::class)
    @Schema(description = "UUID комментария")
    val id: UUID,
    @Serializable(with = UUIDSerializer::class)
    @Schema(description = "UUID поста")
    val postUUID: UUID,
    @Serializable(with = UUIDSerializer::class)
    @Schema(description = "UUID пользователя, оставившего комментарий")
    val userUUID: UUID,
    @Schema(description = "Содержание")
    val content: String
) {
    constructor(comment: CommentEntity): this(
        id = comment.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        postUUID = comment.post?.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        userUUID = comment.user?.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        content = comment.content ?: ""
    )
}