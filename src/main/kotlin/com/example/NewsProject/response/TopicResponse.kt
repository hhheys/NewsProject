package com.example.NewsProject.response

import com.example.NewsProject.entity.TopicEntity
import kotlinx.serialization.Serializable

@Serializable
data class TopicResponse (
    val id: Int,
    val name: String
) {
    constructor(topicEntity: TopicEntity): this(
        id = topicEntity.id ?: 0,
        name = topicEntity.name ?: ""
    )
}