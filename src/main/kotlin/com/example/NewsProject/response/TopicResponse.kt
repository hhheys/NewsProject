package com.example.NewsProject.response

import com.example.NewsProject.entity.TopicEntity
import io.swagger.v3.oas.annotations.media.Schema
import kotlinx.serialization.Serializable

@Serializable
data class TopicResponse (
    @Schema(description = "UUID топика")
    val id: Int,
    @Schema(description = "Название топика")
    var name: String
) {
    constructor(topicEntity: TopicEntity): this(
        id = topicEntity.id ?: 0,
        name = topicEntity.name ?: ""
    )
}