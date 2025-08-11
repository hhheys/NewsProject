package com.example.NewsProject.response

import com.example.NewsProject.entity.ReactionEntity
import com.example.NewsProject.utils.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class ReactionResponse (
    @Serializable(with = UUIDSerializer::class)
    var id: UUID,
    @Serializable(with = UUIDSerializer::class)
    var userUUID: UUID,
    var type: String
) {
    constructor(reaction: ReactionEntity):this(
        id = reaction.id ?: UUID.fromString("0"),
        userUUID = reaction.user?.id ?: UUID.fromString("0"),
        type = reaction.reactionType ?: ""
    )
}