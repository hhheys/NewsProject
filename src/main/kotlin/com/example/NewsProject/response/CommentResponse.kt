package com.example.NewsProject.response

import com.example.NewsProject.entity.CommentEntity
import com.example.NewsProject.utils.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class CommentResponse (
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    @Serializable(with = UUIDSerializer::class)
    val postUUID: UUID,
    @Serializable(with = UUIDSerializer::class)
    val userUUID: UUID,
    val content: String
) {
    constructor(comment: CommentEntity): this(
        id = comment.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        postUUID = comment.post?.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        userUUID = comment.user?.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        content = comment.content ?: ""
    )
}