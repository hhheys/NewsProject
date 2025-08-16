package com.example.NewsProject.dto.kafka

import com.example.NewsProject.consts.EventType
import com.example.NewsProject.utils.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
sealed interface PostEvent {
    val eventType: EventType
    val postUUID: UUID
}

@Serializable
data class ViewEvent(
    override val eventType: EventType = EventType.VIEW,
    @Serializable(with = UUIDSerializer::class)
    override val postUUID: UUID
): PostEvent

@Serializable
data class ReactionEvent(
    override val eventType: EventType,

    @Serializable(with = UUIDSerializer::class)
    override val postUUID: UUID,
    @Serializable(with = UUIDSerializer::class)
    val userUUID: UUID
): PostEvent

@Serializable
data class CommentEvent(
    override val eventType: EventType = EventType.COMMENT,

    @Serializable(with = UUIDSerializer::class)
    override val postUUID: UUID,

    @Serializable(with = UUIDSerializer::class)
    val userUUID: UUID,

    val content: String
): PostEvent

