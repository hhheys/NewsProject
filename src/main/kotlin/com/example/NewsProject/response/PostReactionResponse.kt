package com.example.NewsProject.response

import com.example.NewsProject.entity.ReactionEntity
import com.example.NewsProject.utils.UUIDSerializer
import io.swagger.v3.oas.annotations.media.Schema
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class PostReactionResponse (
    @Serializable(with = UUIDSerializer::class)
    @Schema(description = "UUID поста")
    val postUUID: UUID,

    @Serializable(with = UUIDSerializer::class)
    @Schema(description = "UUID пользователя")
    val userUUID: UUID,

    @Schema(description = "Тип реакции(like/dislike)")
    val reactionType: String
) {
    constructor(reactionEntity: ReactionEntity, reactionType: String):this(
        postUUID = reactionEntity.post?.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        userUUID = reactionEntity.user?.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        reactionType = reactionType
    )
}