package com.example.NewsProject.response

import com.example.NewsProject.entity.ReactionEntity
import com.example.NewsProject.utils.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class PostReactionResponse (
    @Serializable(with = UUIDSerializer::class)
    val postUUID: UUID,

    @Serializable(with = UUIDSerializer::class)
    val userUUID: UUID,

    val reactionType: String
) {
    constructor(reactionEntity: ReactionEntity, reactionType: String):this(
        postUUID = reactionEntity.post?.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        userUUID = reactionEntity.user?.id ?: UUID.fromString("00000000-0000-0000-0000-000000000000"),
        reactionType = reactionType
    )
}